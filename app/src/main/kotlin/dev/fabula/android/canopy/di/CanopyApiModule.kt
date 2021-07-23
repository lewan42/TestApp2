package dev.fabula.android.canopy.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.canopy.api.CanopyApi
import retrofit2.Retrofit

@Module
class CanopyApiModule {
    @Provides
    fun getCanopyApi(retrofit: Retrofit): CanopyApi {
        return retrofit.create(CanopyApi::class.java)
    }
}