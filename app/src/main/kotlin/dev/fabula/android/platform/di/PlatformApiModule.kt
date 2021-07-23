package dev.fabula.android.platform.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.platform.api.PlatformApi
import dev.fabula.android.support.api.SupportApi
import retrofit2.Retrofit

@Module
class PlatformApiModule {
    @Provides
    fun getPlatformApi(retrofit: Retrofit): PlatformApi {
        return retrofit.create(PlatformApi::class.java)
    }
}