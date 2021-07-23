package dev.fabula.android.screen.measurements.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.screen.measurements.model.ListItem
import dev.fabula.android.screen.measurements.repo.ScreenMeasurementsRepository
import dev.fabula.android.section.model.RailwaySection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScreenMeasurementsViewModule @Inject constructor(
    private val repository: ScreenMeasurementsRepository
) :
    BaseViewModel() {

    private val _allStationPeregonsAndSupports = MutableLiveData<List<ListItem>>()
    val allStationPeregonsAndSupports: LiveData<List<ListItem>>
        get() = _allStationPeregonsAndSupports

    fun getAllStationPeregonsAndSupports(
        idRailwaySection: String,
        filterType: String?,
        query: String
    ) {

        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO)
            {
                _allStationPeregonsAndSupports.postValue(
                    repository.allStationPeregonsAndSupports(
                        idRailwaySection,
                        filterType,
                        query
                    )
                )
            }
        }
    }
}