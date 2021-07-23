package dev.fabula.android.synchronize.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.synchronize.api.SyncApi
import retrofit2.Retrofit

@Module
class SyncApiModule {
    @Provides
    fun getSyncApi(retrofit: Retrofit): SyncApi {
        return retrofit.create(SyncApi::class.java)
    }
}