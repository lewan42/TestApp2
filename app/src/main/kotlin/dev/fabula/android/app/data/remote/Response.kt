package dev.fabula.android.app.data.remote

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import java.io.IOException
import java.lang.RuntimeException

class Response<R>(
    @SerializedName("result") private val result: R?,
    @SerializedName("error") val error: Error?
) {

    val data: R
        get() = error?.let { throw RemoteServiceException(it) }
            ?: result
            ?: throw RemoteServiceException(Error(404, "Empty data!"))

    class Error(
        @SerializedName("code") val code: Int,
        @SerializedName("message") val message: String
    )
}

class RemoteServiceException(
    val error: Response.Error
) : RuntimeException(error.message)
