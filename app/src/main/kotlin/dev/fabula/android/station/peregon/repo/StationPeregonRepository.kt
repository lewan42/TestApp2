package dev.fabula.android.station.peregon.repo

import androidx.annotation.WorkerThread
import dev.fabula.android.station.peregon.dao.StationPeregonDao
import dev.fabula.android.station.peregon.model.StationPeregon
import kotlinx.coroutines.flow.Flow
import java.lang.Exception
import javax.inject.Inject

class StationPeregonRepository @Inject constructor(
    private val stationPeregonDao: StationPeregonDao
) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getStationPeregonById(id: String): StationPeregon {
        return stationPeregonDao.getStationPeregonsById(id)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun stationUpdate(
        uidStation: String,
        comment: String,
        photo1: String?,
        photo2: String?
    ): Boolean {
        try {
            stationPeregonDao.update(uidStation, comment, photo1, photo2)
        } catch (e: Exception) {
            return false
        }
        return true
    }
}
