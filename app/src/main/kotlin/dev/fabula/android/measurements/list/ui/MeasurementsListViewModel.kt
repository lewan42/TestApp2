package dev.fabula.android.measurements.list.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.dimensions.fence.model.DimensionsFenceWithMeasurement
import dev.fabula.android.measurements.list.repo.MeasurementsRepository
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.measurements.type.model.MeasurementType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MeasurementsListViewModel @Inject constructor(
    private val repository: MeasurementsRepository
) : BaseViewModel() {

    private val _measurementPlatforms = MutableLiveData<List<Measurement>>()
    val measurementPlatforms: LiveData<List<Measurement>>
        get() = _measurementPlatforms

    private val _measurementBridge = MutableLiveData<List<Measurement>>()
    val measurementBridge: LiveData<List<Measurement>>
        get() = _measurementBridge

    private val _measurementCanopy = MutableLiveData<List<Measurement>>()
    val measurementCanopy: LiveData<List<Measurement>>
        get() = _measurementCanopy

    private val _countLastMeasurementPlatforms = MutableLiveData<Event<List<Measurement>>>()
    val countLastMeasurementPlatforms: LiveData<Event<List<Measurement>>>
        get() = _countLastMeasurementPlatforms

    private val _countLastMeasurementBridge = MutableLiveData<Event<List<Measurement>>>()
    val countLastMeasurementBridge: LiveData<Event<List<Measurement>>>
        get() = _countLastMeasurementBridge

    private val _countLastMeasurementCanopy = MutableLiveData<Event<List<Measurement>>>()
    val countLastMeasurementCanopy: LiveData<Event<List<Measurement>>>
        get() = _countLastMeasurementCanopy

    private val _countLastMeasurementDimensionFence = MutableLiveData<Event<List<DimensionsFenceWithMeasurement>>>()
    val countLastMeasurementDimensionFence: LiveData<Event<List<DimensionsFenceWithMeasurement>>>
        get() = _countLastMeasurementDimensionFence


    private val _canopiesOfPlatform = MutableLiveData<List<Canopy>>()
    val canopiesOfPlatform: LiveData<List<Canopy>>
        get() = _canopiesOfPlatform

    private val _uidTypeMeasurementByTypeOf = MutableLiveData<Event<MeasurementType>>()
    val typeMeasurementByTypeOf: LiveData<Event<MeasurementType>>
        get() = _uidTypeMeasurementByTypeOf


    private val _uidCanopyOfPlatform = MutableLiveData<Event<String?>>()
    val uidCanopyOfPlatform: LiveData<Event<String?>>
        get() = _uidCanopyOfPlatform

    fun getTypeMeasurementByType(typeOf: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _uidTypeMeasurementByTypeOf.postValue(
                    Event(
                        repository.getTypeMeasurementByType(
                            typeOf
                        )
                    )
                )
            }
        }
    }

    fun getCountLastMeasurementsOfPlatform(uidPlatform: String, count: Int) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _countLastMeasurementPlatforms.postValue(Event(repository.getCountLastMeasurementsOfPlatform(uidPlatform, count)))
            }
        }
    }

    fun getCountLastMeasurementsOfBridge(uidBridge: String, count: Int) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _countLastMeasurementBridge.postValue(Event(repository.getCountLastMeasurementsOfBridge(uidBridge, count)))
            }
        }
    }

    fun getCountLastMeasurementsOfCanopy(uidCanopy: String, count: Int) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _countLastMeasurementCanopy.postValue(Event(repository.getCountLastMeasurementsOfCanopy(uidCanopy, count)))
            }
        }
    }


    fun getCountLastMeasurementsOfDimensionFences(dimensionFences: List<DimensionsFence>, count: Int) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _countLastMeasurementDimensionFence.postValue(Event(repository.getCountLastMeasurementsOfDimensionsFence(dimensionFences, count)))
            }
        }
    }

    fun getMeasurementsOfPlatform(uidPlatform: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurementPlatforms.postValue(repository.getMeasurementsOfPlatform(uidPlatform))
            }
        }
    }


    fun getMeasurementsOfBridge(uidBridge: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurementBridge.postValue(repository.getMeasurementsOfBridge(uidBridge))
            }
        }
    }


    fun getCanopiesOfPlatform(uidCanopyOfPlatform: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _canopiesOfPlatform.postValue(repository.getCanopiesOfPlatform(uidCanopyOfPlatform))
            }
        }
    }

    fun getMeasurementsOfCanopy(uidCanopyOfPlatform: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurementCanopy.postValue(repository.getMeasurementsOfCanopy(uidCanopyOfPlatform))
            }
        }
    }

    fun createCanopy(uidPlatform: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _uidCanopyOfPlatform.postValue(Event(repository.createCanopy(uidPlatform)))
            }
        }
    }
}