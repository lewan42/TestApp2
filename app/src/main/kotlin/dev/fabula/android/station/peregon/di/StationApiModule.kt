package dev.fabula.android.station.peregon.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.station.peregon.api.StationApi
import retrofit2.Retrofit

@Module
class StationApiModule {
    @Provides
    fun getStationApi(retrofit: Retrofit): StationApi {
        return retrofit.create(StationApi::class.java)
    }
}