package dev.fabula.android.auth_old

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

class Unauthorised : Throwable()

class AppAuth @Inject constructor(
    context: Context
) {
    private val storage: SharedPreferences =
        context.getSharedPreferences("auth.data", Context.MODE_PRIVATE)

    var user: User? = null
        private set

    init {
        reload()
        storage.registerOnSharedPreferenceChangeListener { _, key ->
            if (key == "user_bearer")
                reload()
        }
    }

    fun getUserID(): String? {
        return storage.getString("user_login", null)
    }

    fun getUserEmail(): String? {
        return storage.getString("user_name", null)
    }

    fun reload() {
        //val bearer = storage.getString("user_bearer", null)
        val token = storage.getString("user_token", null)
        val login = storage.getString("user_login", null)
        val name = storage.getString("user_name", null)
        user = if (token.isNullOrEmpty())
            null
        else
            User(token, login, name)
    }

    fun signIn(bearer: String) {
        storage.edit {
            putString("user_bearer", bearer)
        }
        reload()
    }

    fun signOut() {
        storage.edit { remove("user_token"); remove("user_login"); remove("user_name") }
        user = null
    }

    fun changeUser(login: String?, token: String?, name: String?) {
        storage.edit {
            token?.let { putString("user_token", it) } ?: remove("user_token")
            login?.let { putString("user_login", it) } ?: remove("user_login")
            name?.let { putString("user_name", it) } ?: remove("user_name")
        }
        reload()
    }
}