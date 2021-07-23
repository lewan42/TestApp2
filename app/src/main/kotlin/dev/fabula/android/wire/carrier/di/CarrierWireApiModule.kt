package dev.fabula.android.wire.carrier.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.wire.carrier.api.CarrierWireApi
import retrofit2.Retrofit

@Module
class CarrierWireApiModule {
    @Provides
    fun getCarrierWireApi(retrofit: Retrofit): CarrierWireApi {
        return retrofit.create(CarrierWireApi::class.java)
    }
}