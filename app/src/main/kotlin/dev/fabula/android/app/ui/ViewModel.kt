package dev.fabula.android.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {

    protected val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean>
        get() = _progress

    protected val _error = MutableLiveData<Event<Throwable>>()
    val error: LiveData<Event<Throwable>>
        get() = _error

    protected fun fetchData(block: suspend () -> Unit) {
        (progress as MutableLiveData).value = true
        viewModelScope.launch {
            try {
                block()
            } catch (t: Throwable) {
                Timber.w(t)
                (error as MutableLiveData).value = Event(t)
            } finally {
                (progress as MutableLiveData).value = false
            }
        }
    }
}