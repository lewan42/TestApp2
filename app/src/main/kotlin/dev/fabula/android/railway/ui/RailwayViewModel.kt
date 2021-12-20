package dev.fabula.android.railway.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.railway.model.Railway
import dev.fabula.android.railway.repo.RailwayRepository
import javax.inject.Inject

class RailwayViewModel @Inject constructor(
    repository: RailwayRepository
) : BaseViewModel() {

    val allRailways: LiveData<List<Railway>> = repository.allRailways.asLiveData()
}