package dev.fabula.android.section.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.section.model.RailwaySection
import dev.fabula.android.section.repo.RailwaySectionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RailwaySectionViewModel @Inject constructor(
    private val repository: RailwaySectionRepository
) : BaseViewModel() {

    private val _railwaySections = MutableLiveData<List<RailwaySection>>()
    val railwaySections: LiveData<List<RailwaySection>>
        get() = _railwaySections

    fun getRailwaySections(uid_railway: String) {
        viewModelScope.launch {
            return@launch withContext(Dispatchers.IO) {
                _railwaySections.postValue(repository.getRailwaySections(uid_railway))
            }
        }
    }
}
