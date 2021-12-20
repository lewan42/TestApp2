package dev.fabula.android.platform.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.auth.remote.AuthResponse
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.platform.model.Platform
import dev.fabula.android.platform.repo.PlatformRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlatformViewModule @Inject constructor(
    private val repository: PlatformRepository
) : BaseViewModel() {

    private val _platform = MutableLiveData<Platform>()
    val platform: LiveData<Platform>
        get() = _platform

    private val _platformUpdate = MutableLiveData<Event<Boolean>>()
    val platformUpdate: LiveData<Event<Boolean>>
        get() = _platformUpdate

    private val _canopy = MutableLiveData<Event<Canopy>>()
    val canopy: LiveData<Event<Canopy>>
        get() = _canopy

    private val _dimensionsFencesList = MutableLiveData<Event<List<DimensionsFence>>>()
    val dimensionsFencesList: LiveData<Event<List<DimensionsFence>>>
        get() = _dimensionsFencesList


    private val _support = MutableLiveData<Event<Canopy>>()
    val support: LiveData<Event<Canopy>>
        get() = _support


    fun getPlatformById(uidPlatform: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _platform.postValue(repository.getPlatformById(uidPlatform))
            }
        }
    }

    fun getCanopyOfPlatform(uidPlatform: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _canopy.postValue(Event(repository.getCanopyOfPlatform(uidPlatform)))
            }
        }
    }

    fun getDimensionsFencesOfPlatform(uidPlatform: String, countDimensionsFence: Int) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _dimensionsFencesList.postValue(Event(repository.getDimensionFences(uidPlatform, countDimensionsFence)))
            }
        }
    }


    fun update(
        uidPlatform: String,
        numberWay: String,
        kmWay: String,
        picket: String,
        type1: String,
        type2: String,
        photo1: String?,
        photo2: String?,
        comment: String,
        flag_edited: Boolean
    ) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _platformUpdate.postValue(
                    Event(
                        repository.platformUpdate(
                            uidPlatform,
                            numberWay,
                            kmWay,
                            picket,
                            type1,
                            type2,
                            photo1,
                            photo2,
                            comment,
                            flag_edited
                        )
                    )
                )
            }
        }
    }
}