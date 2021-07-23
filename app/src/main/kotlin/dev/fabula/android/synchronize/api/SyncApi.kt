package dev.fabula.android.synchronize.api

import dev.fabula.android.synchronize.model.SyncResponse
import retrofit2.Response
import retrofit2.http.GET

interface SyncApi {
    @GET("api/v1/sync")
    suspend fun sync(): Response<SyncResponse>
}