package dev.fabula.android.auth_old

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.auth_old.remote.AuthService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import timber.log.Timber
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    val retrofit: Retrofit,
    val auth: AppAuth
) : BaseViewModel() {

    private val service: AuthService by lazy { retrofit.create(AuthService::class.java) }

    private val _validatePhone = MutableLiveData<Event<Map<String, String?>>>()
    val validatePhone : LiveData<Event<Map<String, String?>>>
        get() = _validatePhone

    private val _validateCode = MutableLiveData<Event<Unit>>()
    val validateCode : LiveData<Event<Unit>>
        get() = _validateCode

    fun validatePhone(phone: String, agree: Boolean) {
        val isAgree = if (agree) 1 else 0
        val params = mapOf(
            "phone_number" to phone,
            "is_agree" to isAgree.toString()
        )
        validatePhone(params)
    }

    private fun validatePhone(params: Map<String, String?>) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    service.validatePhone(params)
                }
                _validatePhone.postValue(Event(params))
            } catch (error: Throwable) {
                Timber.w(error, "Validate phone Failed!")
                _error.postValue(Event(error))
            }
        }
    }

    fun tryCode() {
        _validatePhone.value?.let {
            validatePhone(it.peekContent())
        }
    }

    fun validateCode(code: String) {
        val params = _validatePhone.value?.peekContent()?.let {
            mapOf(
                "phone_number" to it["phone_number"],
                "code" to code
            )
        }
        params?.let { validateCode(it) }
    }

    private fun validateCode(params: Map<String, String?>) {
        _progress.postValue(true)
        viewModelScope.launch {
            try {
                val bearer = withContext(Dispatchers.IO) {
                    service.validateCode(params)
                }.data.access_token
                val phone = params["phone_number"]
//                auth.signIn(bearer, phone!!)
                _validateCode.postValue(Event(Unit))
            } catch (error: Throwable) {
                Timber.w(error, "Validate code Failed!")
                _error.postValue(Event(error))
            } finally {
                _progress.postValue(false)
            }
        }
    }
}