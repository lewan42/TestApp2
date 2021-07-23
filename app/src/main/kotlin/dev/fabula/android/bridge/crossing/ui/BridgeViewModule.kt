package dev.fabula.android.bridge.crossing.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.bridge.crossing.repo.BridgeRepository
import dev.fabula.android.support.model.Support
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BridgeViewModule @Inject constructor(
    private val repository: BridgeRepository
) : BaseViewModel() {

    private val _createBridge = MutableLiveData<Event<String?>>()
    val createBridge: LiveData<Event<String?>>
        get() = _createBridge

    fun createBridge(uidPlatform: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _createBridge.postValue(Event(repository.createBridge(uidPlatform)))
            }
        }
    }
}