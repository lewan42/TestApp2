package dev.fabula.android.bridge.crossing.api

import dev.fabula.android.bridge.crossing.model.BridgeCrossing
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface BridgeApi {
    @POST("api/v1/bridge/")
    suspend fun create(
        @Body bridge: BridgeCrossing
    ): Response<BridgeCrossing>
}