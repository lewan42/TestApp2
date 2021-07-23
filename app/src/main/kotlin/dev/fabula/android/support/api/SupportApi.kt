package dev.fabula.android.support.api

import dev.fabula.android.support.model.Support
import dev.fabula.android.support.model.SupportResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface SupportApi {

    @PATCH("api/v1/opora/{uid}/")
    suspend fun supportUpdate(
        @Path("uid") uid: String,
        @Body support: Support
    ): Response<SupportResponse>

    @POST("api/v1/opora/")
    suspend fun supportCreate(
        @Body support: Support
    ): Response<SupportResponse>
}