package dev.fabula.android.app.data.remote

import com.google.gson.annotations.SerializedName

class Response<T>(
    @SerializedName("result") private val result: T?,
    @SerializedName("error") val error: Error?
) {

    val data: T
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
