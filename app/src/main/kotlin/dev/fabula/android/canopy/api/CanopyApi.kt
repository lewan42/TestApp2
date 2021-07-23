package dev.fabula.android.canopy.api

import dev.fabula.android.canopy.model.CanopyRequest
import dev.fabula.android.canopy.model.CanopyResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface CanopyApi {

    @POST("api/v1/gabarit-naves/")
    suspend fun create(
        @Body canopy: CanopyRequest
    ): Response<CanopyResponse>

    @PATCH("api/v1/gabarit-naves/{uid}/")
    suspend fun update(
        @Path("uid") uid: String,
        @Body canopy: CanopyRequest
    ): Response<CanopyResponse>
}