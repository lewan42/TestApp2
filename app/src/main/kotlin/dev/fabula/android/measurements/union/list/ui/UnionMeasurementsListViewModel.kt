package dev.fabula.android.measurements.union.list.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.bosch.otg.model.BoschOtgItemList
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.measurements.union.list.repo.UnionMeasurementsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

class UnionMeasurementsListViewModel @Inject constructor(
    private val repository: UnionMeasurementsRepository
) : BaseViewModel() {
    private val _measurements = MutableLiveData<List<Measurement>>()
    val measurements: LiveData<List<Measurement>>
        get() = _measurements

    private val _measurements2 = MutableLiveData<List<Measurement>>()
    val measurements2: LiveData<List<Measurement>>
        get() = _measurements2

    private val _data = MutableLiveData<List<BoschOtgItemList>>()
    val data: LiveData<List<BoschOtgItemList>>
        get() = _data

    private val _isPhotoUpdate = MutableLiveData<Event<Boolean>>()
    val isPhotoUpdate: LiveData<Event<Boolean>>
        get() = _isPhotoUpdate


    fun photoUpdate(uid: String, photo: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _isPhotoUpdate.postValue(Event(repository.updatePhotoZamer(uid, photo)))
            }
        }
    }

    fun getMeasurements() {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurements.postValue(repository.getCreatedMeasurement())
            }
        }
    }

    fun getMeasurements2() {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurements2.postValue(repository.getCreatedMeasurement())
            }
        }
    }

    fun getDataFromBoschDevice(file: File, context: Context) {

        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO)
            {
                val result = repository.getDataFromBoschDevice(file, context)
                if (result.isNotEmpty())
                    _data.postValue(repository.getDataFromBoschDevice(file, context))
            }
        }
    }
}