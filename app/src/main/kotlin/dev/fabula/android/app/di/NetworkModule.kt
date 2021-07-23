package dev.fabula.android.app.di

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dev.fabula.android.BuildConfig
import dev.fabula.android.R
import dev.fabula.android.auth_old.AppAuth
import dev.fabula.android.auth_old.Unauthorised
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.File
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit
import javax.inject.Named

interface NetworkProvider : GsonProvider {
    @Named("base_url")
    fun provideBaseUrl(): String
    fun provideHttpClient(): OkHttpClient
    fun provideRetrofit(): Retrofit
}

@Module
class NetworkModule {

    @Reusable
    @Provides
    @Named("base_url")
    fun provideBaseUrl(context: Context): String =
        context.getString(R.string.build_props_api_url)

    @Reusable
    @Provides
    fun provideHttpClient(context: Context, auth: AppAuth): OkHttpClient =
        OkHttpClient.Builder()
            .apply {
                if (BuildConfig.DEBUG)
                    addNetworkInterceptor(provideLoggingInterceptor())
            }
            .connectionSpecs(mutableListOf(ConnectionSpec.CLEARTEXT))
            .addInterceptor(provideErrorsInterceptor())
            .addInterceptor(provideAuthInterceptor(auth))
//            .addInterceptor(provideOfflineCacheInterceptor())
//            .addNetworkInterceptor(provideCacheInterceptor())
//            .cache(getCache(context))
            .build()

    @Reusable
    @Provides
    fun provideRetrofit(
        @Named("base_url") baseUrl: String,
        client: OkHttpClient,
        converter: Gson
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(converter))
            .client(client)
            .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger { message ->
                Timber.tag("OkHttp").d(message)
            }
        ).apply { level = HttpLoggingInterceptor.Level.BODY }

    //setup cache size and cache directory
    private fun getCache(context: Context): Cache {
        val httpCacheDirectory =
            File(context.cacheDir, "httpCache")
        return Cache(httpCacheDirectory, 10 * 1024 * 1024)
    }

    private fun provideOfflineCacheInterceptor() =
        Interceptor { chain ->
            var request = chain.request()
            try {
                chain.proceed(request)
            } catch (errorHost: UnknownHostException) {
                val cacheControl = CacheControl.Builder()
                    .onlyIfCached()
                    .maxStale(1 * 365, TimeUnit.DAYS) // hello luntick!
                    .build()
                request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build()
                chain.proceed(request)
            }
        }

    private fun provideCacheInterceptor() =
        Interceptor { chain ->
            val response = chain.proceed(chain.request())
            val cacheControl = CacheControl.Builder()
                .maxAge(10, TimeUnit.SECONDS)
                .build()
            response.newBuilder()
                .header("Cache-Control", cacheControl.toString())
//                .header("Content-Type", "application/json")
//                .header("Accept", "application/json")
                .build()
        }

    private fun provideAuthInterceptor(auth: AppAuth) =
        Interceptor { chain ->
            chain.proceed(
                chain.request().newBuilder().apply {
                //     addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjM3NDA2MTczLCJqdGkiOiI2MTRjMDlhYWU2NTY0MmU3OTQ5N2NmY2Y3MjBmODVlYiIsInVzZXJfaWQiOjJ9.CWfVW3jnlMgDteX-eIvmhvohA7ndkemXqZn1T5fkB9g")
                    if (auth.user == null)
                        auth.reload()
                    auth.user?.let { user ->
                        addHeader("Authorization", "Bearer ${user.token}")
                    }
                }.build()
            )
        }

    private fun provideErrorsInterceptor() =
        Interceptor { chain ->
            chain.proceed(chain.request()).apply {
                when (code()) {
                    401, 403 -> throw Unauthorised()
//                    503 -> throw OfflineNoData() //todo
                }
            }
        }
}

//class OfflineNoData : Throwable()

/*

eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjM3MzAyNTM5LCJqdGkiOiI3MGM3NTc1MTgzOWE0ODQxODY4MDM5OWI2NmU0N2QzMSIsInVzZXJfaWQiOjJ9.EH7dFbTQe2Lo5sIuimjmOxbYCoxkZI9KAtogasr_DCA

 */