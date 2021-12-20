package dev.fabula.android.measurements.create.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.bosch.otg.model.BoschOtgItemList
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.measurements.create.repo.CreateMeasurementsRepository
import dev.fabula.android.measurements.model.BoschMeasurement
import dev.fabula.android.measurements.model.Measurement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CreateMeasurementsViewModel @Inject constructor(
    private val repository: CreateMeasurementsRepository
) : BaseViewModel() {

    var objectMeasurement = MutableLiveData<Event<BoschOtgItemList>>()

    private val _measurement = MutableLiveData<Event<Measurement>>()
    val measurement: LiveData<Event<Measurement>>
        get() = _measurement

    private val _measurementInsert = MutableLiveData<Event<Boolean>>()
    val measurementInsert: LiveData<Event<Boolean>>
        get() = _measurementInsert

    private val _insertDimensionFence = MutableLiveData<Event<List<Long>>>()
    val insertDimensionFence: LiveData<Event<List<Long>>>
        get() = _insertDimensionFence


    fun create(measurement: Measurement) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurementInsert.postValue(Event(repository.insert(measurement)))
            }
        }
    }

    fun create(measurements: List<Measurement>) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurementInsert.postValue(Event(repository.insertAll(measurements)))
            }
        }
    }

    fun createDimensionFences(dimensionsFence: List<DimensionsFence>) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _insertDimensionFence.postValue(Event(repository.insertDimensionFences(dimensionsFence)))
            }
        }
    }


    fun createDimensionAndMeasurement(
        measurement: Measurement,
        dimensionsFence: DimensionsFence
    ) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurementInsert.postValue(
                    Event(
                        repository.insertDimensionAndMeasurement(
                            measurement,
                            dimensionsFence
                        )
                    )
                )
            }
        }
    }

    fun getMeasurementById(uid: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurement.postValue(Event(repository.getMeasurementById(uid)))
            }
        }
    }
}