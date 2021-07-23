package dev.fabula.android.synchronize.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.synchronize.repo.SyncRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SyncViewModule @Inject constructor(
    private val syncRepo: SyncRepository
) : BaseViewModel() {

    private val _sync = MutableLiveData<Event<Boolean>>()
    val sync: LiveData<Event<Boolean>>
        get() = _sync

    fun sync() {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _sync.postValue(Event(syncRepo.sync()))
            }
        }
    }
}