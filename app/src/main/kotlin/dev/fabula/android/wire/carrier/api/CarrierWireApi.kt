package dev.fabula.android.wire.carrier.api

import dev.fabula.android.wire.carrier.model.CarrierWireRequest
import dev.fabula.android.wire.carrier.model.CarrierWireResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface CarrierWireApi {

    @POST("api/v1/main-wire/")
    suspend fun create(
        @Body carrierWire: CarrierWireRequest
    ): Response<CarrierWireResponse>
}