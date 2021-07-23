package dev.fabula.android.screen.measurements.repo

import androidx.annotation.WorkerThread
import dev.fabula.android.app.util.Util
import dev.fabula.android.screen.measurements.model.ListItem
import dev.fabula.android.station.peregon.dao.StationPeregonDao
import dev.fabula.android.station.peregon.model.StationPeregon
import dev.fabula.android.support.dao.SupportDao
import dev.fabula.android.support.model.Support
import javax.inject.Inject

class ScreenMeasurementsRepository @Inject constructor(
    private val stationPeregonDao: StationPeregonDao,
    private val supportDao: SupportDao
) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun allStationPeregonsAndSupports(
        idRailwaySection: String,
        filterType: String?,
        query: String
    ) = if (filterType != null) {
        when (filterType) {
            Util.support -> {
                supportDao.getListSupportsByIdAndQuery(
                    idRailwaySection,
                    query
                ).map(::supportToItem)

            }
            else -> {
                stationPeregonDao.getListStationOrPeregonByIdAndTypeAndQuery(
                    idRailwaySection,
                    filterType,
                    query
                ).map(::stationPeregonToItem)
            }
        }

    } else {

        stationPeregonDao.getStationPeregonsByIdAndQuery(idRailwaySection, query)
            .map(::stationPeregonToItem) +
                supportDao.getListSupportsByIdAndQuery(
                    idRailwaySection,
                    query
                ).map(::supportToItem)
    }

    private fun supportToItem(support: Support) =
        ListItem(support.uid, support.parent_uid, support.number, Util.support)

    private fun stationPeregonToItem(station: StationPeregon) =
        ListItem(station.uid, station.railway_sector_uid, station.name, station.type_of)
}




