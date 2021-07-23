package dev.fabula.android.support.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.auth.remote.AuthResponse
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.support.model.Support
import dev.fabula.android.support.repo.SupportRepository
import dev.fabula.android.wire.carrier.model.CarrierWire
import dev.fabula.android.wire.contact.model.ContactWire
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SupportViewModule @Inject constructor(
    private val repository: SupportRepository
) : BaseViewModel() {

    private val _updateSupport = MutableLiveData<Event<Boolean>>()
    val updateSupport: LiveData<Event<Boolean>>
        get() = _updateSupport

    private val _createIfNotExist = MutableLiveData<Event<Boolean>>()
    val createIfNotExist: LiveData<Event<Boolean>>
        get() = _createIfNotExist

    private val _support = MutableLiveData<Event<Support>>()
    val support: LiveData<Event<Support>>
        get() = _support

    private val _createContactWireForHeight = MutableLiveData<Event<ContactWire?>>()
    val createContactWireForHeight: LiveData<Event<ContactWire?>>
        get() = _createContactWireForHeight

    private val _contactWireForZigzag = MutableLiveData<Event<ContactWire?>>()
    val contactWireForZigzag: LiveData<Event<ContactWire?>>
        get() = _contactWireForZigzag

    private val _carrierWireForHeight = MutableLiveData<Event<CarrierWire?>>()
    val carrierWireForHeight: LiveData<Event<CarrierWire?>>
        get() = _carrierWireForHeight

    private val _carrierWireForZigzag = MutableLiveData<Event<CarrierWire?>>()
    val carrierWireForZigzag: LiveData<Event<CarrierWire?>>
        get() = _carrierWireForZigzag

    private val _measurement = MutableLiveData<Event<Measurement?>>()
    val measurement: LiveData<Event<Measurement?>>
        get() = _measurement

    private val _uidSupportOfPlatform = MutableLiveData<Event<String?>>()
    val uidCreatedSupportOfPlatform: LiveData<Event<String?>>
        get() = _uidSupportOfPlatform


    fun getContactWireForHeightBySupport(
        uidSupport: String
    ) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _createContactWireForHeight.postValue(
                    Event(
                        repository.getContactWireForBySupport(
                            uidSupport
                        )
                    )
                )
            }
        }
    }

    fun getContactWireForZigzagBySupport(uidSupport: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _contactWireForZigzag.postValue(
                    Event(
                        repository.getContactWireForBySupport(
                            uidSupport
                        )
                    )
                )
            }
        }
    }

    fun getCarrierWireForHeightBySupport(uidSupport: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _carrierWireForHeight.postValue(
                    Event(
                        repository.getCarrierWireForBySupport(
                            uidSupport
                        )
                    )
                )
            }
        }
    }

    fun getCarrierWireForZigzagBySupport(uidSupport: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _carrierWireForZigzag.postValue(
                    Event(
                        repository.getCarrierWireForBySupport(
                            uidSupport
                        )
                    )
                )
            }
        }
    }

    fun getSupportById(uidSupport: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _support.postValue(Event(repository.getSupportById(uidSupport)))
            }
        }
    }

    fun getMeasurementByParentContactWire(uidContactWire: String, uidTypeMeasurement: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurement.postValue(
                    Event(
                        repository.getMeasurementByParentContactWire(
                            uidContactWire, uidTypeMeasurement
                        )
                    )
                )
            }
        }
    }

    fun getMeasurementByParentCarrierWire(uidCarrierWire: String, uidTypeMeasurement: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurement.postValue(
                    Event(
                        repository.getMeasurementByParentCarrierWire(
                            uidCarrierWire, uidTypeMeasurement
                        )
                    )
                )
            }
        }
    }

    fun createSupport(
        uidPlatform: String,
        contentType: String,
        number: String,
        kmWay: String,
        wayNumber: String,
        picket: String,
        photo1: String?,
        photo2: String?
    ) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _uidSupportOfPlatform.postValue(
                    Event(
                        repository.createSupport(
                            uidPlatform,
                            contentType,
                            number,
                            kmWay,
                            wayNumber,
                            picket,
                            photo1,
                            photo2
                        )
                    )
                )
            }
        }
    }

    fun updateSupport(
        uidSupport: String,
        number: String,
        kmWay: String,
        wayNumber: String,
        picket: String,
        comment: String?,
        photo1: String?,
        photo2: String?
    ) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                try {
                    _updateSupport.postValue(
                        Event(
                            repository.supportUpdate(
                                uidSupport,
                                number,
                                kmWay,
                                wayNumber,
                                picket,
                                comment,
                                photo1,
                                photo2
                            )
                        )
                    )
                } catch (e: Exception) {
                }
            }
        }
    }
}