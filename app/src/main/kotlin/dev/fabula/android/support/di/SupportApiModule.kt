package dev.fabula.android.support.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.auth.remote.AuthService
import dev.fabula.android.support.api.SupportApi
import retrofit2.Retrofit

@Module
class SupportApiModule {
    @Provides
    fun getSupportApi(retrofit: Retrofit): SupportApi {
        return retrofit.create(SupportApi::class.java)
    }
}