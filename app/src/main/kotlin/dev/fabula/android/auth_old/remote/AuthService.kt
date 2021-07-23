package dev.fabula.android.auth_old.remote

import dev.fabula.android.app.data.remote.Response
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    @FormUrlEncoded
    @POST("phone-validate")
    suspend fun validatePhone(@FieldMap data: Map<String, String?>) : Response<CodeResponse>

    @FormUrlEncoded
    @POST("validate-code")
    suspend fun validateCode(@FieldMap data: Map<String, String?>) : Response<AuthResponse>
}