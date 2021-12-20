package dev.fabula.android.auth.remote

import dev.fabula.android.auth_old.remote.UserRequest
import dev.fabula.android.auth_old.remote.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("api/v1/sign-in/")
    suspend fun trySingIn(
        @Body userAuth: AuthRequest
    ): AuthResponse

    @POST("api/v1/?/")
    suspend fun isValidToken(): AuthResponse


    @POST("register/")
    suspend fun trySingIn(
        @Body userAuth: UserRequest
    ): UserResponse
}