package dev.fabula.android.bosch.otg.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.bosch.otg.model.BoschOtgItemList
import dev.fabula.android.bosch.otg.repo.BoschOtgRepository
import dev.fabula.android.measurements.model.Measurement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

class BoschOtgViewModule @Inject constructor(private val repository: BoschOtgRepository) :
    BaseViewModel() {

    private val _data = MutableLiveData<List<BoschOtgItemList>>()
    val data: LiveData<List<BoschOtgItemList>>
        get() = _data

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