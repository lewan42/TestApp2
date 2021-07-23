package dev.fabula.android.dimensions.fence.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.dimensions.fence.api.DimensionFenceAPI

import retrofit2.Retrofit

@Module
class DimensionsFenceApiModule {
    @Provides
    fun getDimensionApi(retrofit: Retrofit): DimensionFenceAPI {
        return retrofit.create(DimensionFenceAPI::class.java)
    }
}