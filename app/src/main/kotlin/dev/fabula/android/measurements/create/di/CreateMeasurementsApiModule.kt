package dev.fabula.android.measurements.create.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.measurements.create.api.CreateMeasurementsApi
import retrofit2.Retrofit

@Module
class CreateMeasurementsApiModule {
    @Provides
    fun getMeasurementApi(retrofit: Retrofit): CreateMeasurementsApi {
        return retrofit.create(CreateMeasurementsApi::class.java)
    }
}