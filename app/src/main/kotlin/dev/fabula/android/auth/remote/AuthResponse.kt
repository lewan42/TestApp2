package dev.fabula.android.auth.remote

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("results")
    val results: List<BodyResponse>
)

data class BodyResponse(
    @SerializedName("uid")
    val uid: String,
    @SerializedName("first_name")
    val first_name: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("jwt_token")
    val jwt_token: String
)
