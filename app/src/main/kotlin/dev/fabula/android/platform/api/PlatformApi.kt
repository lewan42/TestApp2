package dev.fabula.android.platform.api

import dev.fabula.android.platform.model.Platform
import dev.fabula.android.platform.model.PlatformRequest
import dev.fabula.android.platform.model.PlatformResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.PUT
import retrofit2.http.Path

interface PlatformApi {

    @PATCH("api/v1/platform/{uid}/")
    suspend fun update(
        @Path("uid") uid: String,
        @Body platform: PlatformRequest
    ): Response<PlatformResponse>
}