package dev.fabula.android.list.items.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import dev.fabula.android.auth_old.AppAuth
import dev.fabula.android.list.items.model.ListItem
import dev.fabula.android.list.items.repo.ListItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ListItemsViewModel @Inject constructor(
    private val repository: ListItemsRepository,
    private val auth: AppAuth
) :
    BaseViewModel() {

    private val items: MutableLiveData<List<ListItem>> =
        MutableLiveData<List<ListItem>>()

    //    railway section
    fun fetchPlatformsOfRailwaySection(uidStationOrPeregon: String): LiveData<List<ListItem>> {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                items.postValue(
                    repository.getPlatformsOfStationOrPeregon(
                        uidStationOrPeregon
                    )
                )
            }
        }
        return items
    }

    fun fetchSupportOfRailwaySection(uidSupport: String): LiveData<List<ListItem>> {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                items.postValue(
                    repository.getSupports(
                        uidSupport
                    )
                )
            }
        }
        return items
    }


    //    platforms
    fun fetchDimensionFenceOfPlatform(uidPlatform: String): LiveData<List<ListItem>> {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                items.postValue(
                    repository.getDimensionFenceOfPlatform(
                        uidPlatform
                    )
                )
            }
        }
        return items
    }

    fun fetchBridgesOfPlatform(uidPlatform: String): LiveData<List<ListItem>> {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                items.postValue(
                    repository.getBridgesOfPlatform(
                        uidPlatform
                    )
                )
            }
        }
        return items
    }

    fun fetchSupportsOfPlatform(uidPlatform: String): LiveData<List<ListItem>> {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                items.postValue(
                    repository.getSupportsOfPlatform(
                        uidPlatform
                    )
                )
            }
        }
        return items
    }

    fun fetchSupportsOfBridge(uidBridge: String): LiveData<List<ListItem>> {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                items.postValue(
                    repository.getSupportsOfPlatform(
                        uidBridge
                    )
                )
            }
        }
        return items
    }
}