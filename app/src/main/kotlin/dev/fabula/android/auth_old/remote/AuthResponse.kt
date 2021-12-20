package dev.fabula.android.auth_old.remote

class CodeResponse (
    val code: String
)

class AuthResponse (
    val access_token: String
)

data class UserRequest(var username: String, var password: String, var imei: String) {
}

data class UserResponse(var id: Int, var username: String, var imei: String) {
}

