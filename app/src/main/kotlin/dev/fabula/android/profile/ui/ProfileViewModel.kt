package dev.fabula.android.profile.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.auth_old.AppAuth
import dev.fabula.android.synchronize.repo.SyncRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val repository: SyncRepository,
    private val auth: AppAuth,
) :
    BaseViewModel() {
    private val _isNotSyncData = MutableLiveData<Event<Boolean>>()
    val isNotSyncData: LiveData<Event<Boolean>>
        get() = _isNotSyncData

    private val _deleteAllData = MutableLiveData<Event<Boolean>>()
    val deleteAllData: LiveData<Event<Boolean>>
        get() = _deleteAllData


    fun checkNotSyncData() {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _isNotSyncData.postValue(Event(repository.isNotSyncData()))
            }
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _deleteAllData.postValue(Event(repository.removeAll()))
            }
        }
    }

    fun getEmailName(): String? {
        return auth.getUserEmail()
    }

    fun exit() {
        auth.signOut()
    }
}