package dev.fabula.android.report.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.canopy.repo.CanopyRepository
import dev.fabula.android.dimensions.fence.model.DimensionsWithMeasure
import dev.fabula.android.dimensions.fence.repo.DimensionsFenceRepository
import dev.fabula.android.measurements.list.repo.MeasurementsRepository
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.measurements.type.model.MeasurementType
import dev.fabula.android.platform.model.Platform
import dev.fabula.android.platform.repo.PlatformRepository
import dev.fabula.android.railway.model.Railway
import dev.fabula.android.railway.repo.RailwayRepository
import dev.fabula.android.report.repo.ReportRepository
import dev.fabula.android.screen.measurements.model.ListItem
import dev.fabula.android.screen.measurements.repo.ScreenMeasurementsRepository
import dev.fabula.android.section.model.RailwaySection
import dev.fabula.android.section.repo.RailwaySectionRepository
import dev.fabula.android.station.peregon.model.StationPeregon
import dev.fabula.android.station.peregon.repo.StationPeregonRepository
import dev.fabula.android.support.model.Support
import dev.fabula.android.support.repo.SupportRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReportViewModel @Inject constructor(
    private val repository: RailwayRepository,
    private val repositorySection: RailwaySectionRepository,
    private val repositorySupport: SupportRepository,
    private val repositoryScreenMeasurements: ScreenMeasurementsRepository,

    private val repositoryReport: ReportRepository,
    private val repositoryPlatform: PlatformRepository,
    private val repositoryMeasurement: MeasurementsRepository,
    private val repositoryStation: StationPeregonRepository,
    private val repositoryDimensionsFence: DimensionsFenceRepository,
    private val repositoryCanopy: CanopyRepository

    ) : BaseViewModel() {

    private val _measurementPlatforms = MutableLiveData<List<Measurement>>()
    val measurementPlatforms: LiveData<List<Measurement>>
        get() = _measurementPlatforms

    private val _platform = MutableLiveData<Platform>()
    val platform: LiveData<Platform>
        get() = _platform

    private val _station = MutableLiveData<StationPeregon>()
    val station: LiveData<StationPeregon>
        get() = _station

    private val _dimensionFence = MutableLiveData<List<DimensionsWithMeasure>>()
    val dimensionFence: LiveData<List<DimensionsWithMeasure>>
        get() = _dimensionFence

    private val _canopy = MutableLiveData<Canopy>()
    val canopy: LiveData<Canopy>
        get() = _canopy

    private val _measurementsOfCanopy = MutableLiveData<List<Measurement>>()
    val measurementsOfCanopy: LiveData<List<Measurement>>
        get() = _measurementsOfCanopy

    private val _support = MutableLiveData<Event<Support>>()
    val support: LiveData<Event<Support>>
        get() = _support



    fun getDimensionList(uidPlatform: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _dimensionFence.postValue(repositoryDimensionsFence.getDimensionList(uidPlatform))
            }
        }
    }

    fun getMeasurementsOfCanopy(uidCanopy: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurementsOfCanopy.postValue(repositoryCanopy.getMeasurementsOfCanopy(uidCanopy))
            }
        }
    }

    fun getCanopyOfPlatform(uidPlatform: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _canopy.postValue(repositoryPlatform.getCanopyOfPlatform(uidPlatform))
            }
        }
    }

    fun getStationPeregon(uid: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO)
            {
                _station.postValue(repositoryStation.getStationPeregonById(uid))
            }
        }
    }

    fun getMeasurementsOfPlatform(uidPlatform: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _measurementPlatforms.postValue(repositoryMeasurement.getMeasurementsOfPlatform(uidPlatform))
            }
        }
    }

    fun getPlatformById(uidPlatform: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _platform.postValue(repositoryPlatform.getPlatformById(uidPlatform))
            }
        }
    }
}
