package dev.fabula.android.canopy.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.canopy.repo.CanopyRepository
import dev.fabula.android.measurements.model.Measurement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CanopyViewModel @Inject constructor(
    private val repository: CanopyRepository
) : BaseViewModel() {

    private val _canopy = MutableLiveData<Event<Canopy>>()
    val canopy: LiveData<Event<Canopy>>
        get() = _canopy

    private val _canopyForSave = MutableLiveData<Event<Canopy>>()
    val canopyForSave: LiveData<Event<Canopy>>
        get() = _canopyForSave

    private val _updateMeasurementOfCanopy = MutableLiveData<Event<Boolean>>()
    val updateMeasurementOfCanopy: LiveData<Event<Boolean>>
        get() = _updateMeasurementOfCanopy

    private val _measurementsOfCanopy = MutableLiveData<Event<List<Measurement>>>()
    val measurementsOfCanopy: LiveData<Event<List<Measurement>>>
        get() = _measurementsOfCanopy


    fun measurementsOfCanopy(uidCanopy: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurementsOfCanopy.postValue(Event(repository.getMeasurementsOfCanopy(uidCanopy)))
            }
        }
    }

    fun getCanopyById(uidCanopy: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _canopy.postValue(Event(repository.getCanopyById(uidCanopy)))
            }
        }
    }

    fun getCanopyByIdForSave(uidCanopy: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _canopyForSave.postValue(Event(repository.getCanopyById(uidCanopy)))
            }
        }
    }


    fun updateMeasurementOfCanopy(
        uidCanopy: String,
        uid1: String, v1: String, h1: String,
        uid2: String, v2: String, h2: String,
        uid3: String, v3: String, h3: String
    ) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _updateMeasurementOfCanopy.postValue(
                    Event(
                        repository.updateMeasurementOfCanopy(
                            uidCanopy, uid1, v1, h1, uid2, v2, h2, uid3, v3, h3
                        )
                    )
                )
            }
        }
    }
}