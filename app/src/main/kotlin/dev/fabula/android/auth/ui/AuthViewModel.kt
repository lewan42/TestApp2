package dev.fabula.android.auth.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.auth.remote.AuthRequest
import dev.fabula.android.auth.remote.AuthResponse
import dev.fabula.android.auth.remote.AuthService
import dev.fabula.android.auth_old.AppAuth
import dev.fabula.android.synchronize.repo.SyncRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import timber.log.Timber
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    val retrofit: Retrofit,
    val auth: AppAuth,
    private val syncRepo: SyncRepository
) : BaseViewModel() {

    private val service: AuthService by lazy { retrofit.create(AuthService::class.java) }

    private val _singIn = MutableLiveData<Event<Boolean>>()
    val singIn: LiveData<Event<Boolean>>
        get() = _singIn


    fun trySingIn(email: String, password: String) {
        _progress.postValue(true)
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                try {
                    val authResponse = service.trySingIn(AuthRequest(email, password))
                    Timber.e(authResponse.toString())
                    auth.changeUser(
                        authResponse.results[0].uid,
                        authResponse.results[0].jwt_token,
                        authResponse.results[0].first_name
                    )
                    _singIn.postValue(Event(true))
                } catch (error: Throwable) {
                    _error.postValue(Event(error))
                } finally {
                    _progress.postValue(false)
                }
            }
        }
    }
}