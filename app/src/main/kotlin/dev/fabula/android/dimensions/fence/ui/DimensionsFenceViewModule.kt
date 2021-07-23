package dev.fabula.android.dimensions.fence.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.dimensions.fence.model.DimensionSaveDB
import dev.fabula.android.dimensions.fence.model.DimensionsWithMeasure
import dev.fabula.android.dimensions.fence.repo.DimensionsFenceRepository
import dev.fabula.android.platform.model.Platform
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DimensionsFenceViewModule @Inject constructor(
    private val repository: DimensionsFenceRepository
) : BaseViewModel() {

    private val _platform = MutableLiveData<Platform>()
    val platform: LiveData<Platform>
        get() = _platform

    private val _dimensionFence = MutableLiveData<List<DimensionsWithMeasure>>()
    val dimensionFence: LiveData<List<DimensionsWithMeasure>>
        get() = _dimensionFence

    private val _dimensionUpdate = MutableLiveData<Event<Boolean>>()
    val dimensionUpdate: LiveData<Event<Boolean>>
        get() = _dimensionUpdate


    fun fetchDimensionList(uidPlatform: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _dimensionFence.postValue(repository.getDimensionList(uidPlatform))
            }
        }
    }

    fun updateDimension(
        list: List<DimensionSaveDB>
    ) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _dimensionUpdate.postValue(
                    Event(
                        repository.updateDimension(
                            list
                        )
                    )
                )
            }
        }
    }
}