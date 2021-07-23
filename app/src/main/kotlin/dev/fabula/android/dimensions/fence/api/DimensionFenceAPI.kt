package dev.fabula.android.dimensions.fence.api

import dev.fabula.android.dimensions.fence.model.DimensionsFenceRequest
import dev.fabula.android.dimensions.fence.model.DimensionsFenceResponse
import retrofit2.Response
import retrofit2.http.*

interface DimensionFenceAPI {
    @PATCH("api/v1/gabarit-tor/{uid}/")
    suspend fun update(
        @Path("uid") uid: String,
        @Body dimensionsFence: DimensionsFenceRequest
    ): Response<DimensionsFenceResponse>

    @POST("api/v1/gabarit-tor/")
    suspend fun create(
        @Body dimensionsFence: DimensionsFenceRequest
    ): Response<DimensionsFenceResponse>
}