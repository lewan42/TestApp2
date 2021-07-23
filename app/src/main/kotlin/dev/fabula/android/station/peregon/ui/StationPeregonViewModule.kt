package dev.fabula.android.station.peregon.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.station.peregon.model.StationPeregon
import dev.fabula.android.station.peregon.repo.StationPeregonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StationPeregonViewModule @Inject constructor(
    val repository: StationPeregonRepository
) : BaseViewModel() {

    private val _station = MutableLiveData<StationPeregon>()
    val station: LiveData<StationPeregon>
        get() = _station

    private val _stationUpdate = MutableLiveData<Event<Boolean>>()
    val stationUpdate: LiveData<Event<Boolean>>
        get() = _stationUpdate

    fun stationPeregon(uid: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO)
            {
                _station.postValue(repository.getStationPeregonById(uid))
            }
        }
    }

    fun stationPeregonUpdate(
        uidStation: String,
        comment: String,
        photo1: String?,
        photo2: String?
    ) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO)
            {
                _stationUpdate.postValue(
                    Event(
                        repository.stationUpdate(
                            uidStation,
                            comment,
                            photo1,
                            photo2
                        )
                    )
                )
            }
        }
    }
}