package dev.fabula.android.app.ui

import dev.fabula.android.R
import dev.fabula.android.app.data.remote.RemoteServiceException
import dev.fabula.android.auth_old.Unauthorised
import retrofit2.HttpException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

val Throwable.localizedMessageResId: Int
    get() {
        return when (this) {
            is Unauthorised -> R.string.message_error_http_401
            is RemoteServiceException -> this.localizedMessageResId
            is HttpException -> this.localizedMessageResId
            is TimeoutException,
            is UnknownHostException -> R.string.message_error_connection
            else -> cause?.localizedMessageResId ?: R.string.message_error_unknown
        }
    }

val HttpException.localizedMessageResId: Int
    get() {
        return when {
            code() == 504 -> R.string.message_error_http_504x
            code() >= 500 -> R.string.message_error_http_500x
            code() == 404 -> R.string.message_error_http_404
            code() == 401 -> R.string.message_error_http_401
            code() >= 400 -> R.string.message_error_http_400x
            code() >= 300 -> R.string.message_error_http_300x
            else -> R.string.message_error_http_unknown
        }
    }

val RemoteServiceException.localizedMessageResId: Int
    get() {
        return when {
            error.code == 404 -> R.string.message_error_api_404
            else -> -1
        }
    }