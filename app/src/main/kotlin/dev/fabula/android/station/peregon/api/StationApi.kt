package dev.fabula.android.station.peregon.api

import dev.fabula.android.station.peregon.model.StationPeregon
import dev.fabula.android.station.peregon.model.StationRequest
import dev.fabula.android.station.peregon.model.StationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.PUT
import retrofit2.http.Path

interface StationApi {

    @PATCH("http://as-24.ru/api/v1/station/{uid}/")
    suspend fun update(
        @Path("uid") uid: String,
        @Body stationRequest: StationRequest
    ): Response<StationResponse>
}