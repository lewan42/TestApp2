package dev.fabula.android.auth.remote

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("api/v1/sign-in/")
    suspend fun trySingIn(
        @Body userAuth: AuthRequest
    ): AuthResponse

    @POST("api/v1/contact-wire/")
    suspend fun isValidToken(): AuthResponse
}
