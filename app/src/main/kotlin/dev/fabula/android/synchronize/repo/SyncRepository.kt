package dev.fabula.android.synchronize.repo

import android.annotation.SuppressLint
import android.util.Log
import dev.fabula.android.auth_old.AppAuth
import dev.fabula.android.bridge.crossing.api.BridgeApi
import dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao
import dev.fabula.android.bridge.crossing.model.BridgeCrossing
import dev.fabula.android.canopy.api.CanopyApi
import dev.fabula.android.canopy.dao.CanopyDao
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.canopy.model.CanopyRequest
import dev.fabula.android.dimensions.fence.api.DimensionFenceAPI
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.dimensions.fence.model.DimensionsFenceRequest
import dev.fabula.android.measurements.create.api.CreateMeasurementsApi
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.measurements.model.MeasurementRequest
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao
import dev.fabula.android.measurements.type.model.MeasurementType
import dev.fabula.android.platform.api.PlatformApi
import dev.fabula.android.platform.dao.PlatformDao
import dev.fabula.android.platform.model.Platform
import dev.fabula.android.platform.model.PlatformRequest
import dev.fabula.android.railway.dao.RailwayDao
import dev.fabula.android.railway.model.Railway
import dev.fabula.android.section.dao.RailwaySectionDao
import dev.fabula.android.section.model.RailwaySection
import dev.fabula.android.station.peregon.api.StationApi
import dev.fabula.android.station.peregon.dao.StationPeregonDao
import dev.fabula.android.station.peregon.model.StationPeregon
import dev.fabula.android.station.peregon.model.StationRequest
import dev.fabula.android.support.api.SupportApi
import dev.fabula.android.support.dao.SupportDao
import dev.fabula.android.support.model.Support
import dev.fabula.android.synchronize.api.SyncApi
import dev.fabula.android.synchronize.model.SyncResponse
import dev.fabula.android.wire.carrier.api.CarrierWireApi
import dev.fabula.android.wire.carrier.dao.CarrierWireDao
import dev.fabula.android.wire.carrier.model.CarrierWire
import dev.fabula.android.wire.carrier.model.CarrierWireRequest
import dev.fabula.android.wire.contact.api.ContactWireApi
import dev.fabula.android.wire.contact.dao.ContactWireDao
import dev.fabula.android.wire.contact.model.ContactWire
import dev.fabula.android.wire.contact.model.ContactWireRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class SyncRepository @Inject constructor(
    private val auth: AppAuth,
    private val syncApi: SyncApi,

    private val railwayDao: RailwayDao,
    private val railwaySectionDao: RailwaySectionDao,
    private val stationPeregonDao: StationPeregonDao,
    private val platformDao: PlatformDao,
    private val supportDao: SupportDao,
    private val createMeasurementsDao: CreateMeasurementsDao,
    private val bridgeCrossingDao: BridgeCrossingDao,
    private val dimensionsFenceDao: DimensionsFenceDao,
    private val canopyDao: CanopyDao,
    private val contactWireDao: ContactWireDao,
    private val carrierWireDao: CarrierWireDao,

    private val stationApi: StationApi,
    private val platformApi: PlatformApi,
    private val createMeasurementsApi: CreateMeasurementsApi,
    private val dimensionFenceAPI: DimensionFenceAPI,
    private val contactWireApi: ContactWireApi,
    private val carrierWireApi: CarrierWireApi,
    private val measurementTypeDao: MeasurementTypeDao,
    private val canopyApi: CanopyApi,
    private val supportApi: SupportApi,
    private val bridgeApi: BridgeApi
) {
    suspend fun sync(): Boolean {
        return withContext(Dispatchers.IO) {
            var result = true
            if (upload()) {

                if (!removeAll()) {
                    result = false
                } else {

                    val response = syncApi.sync()
                    val tmpRes = response.body()

                    if (!response.isSuccessful) {
                        result = false
                    } else if (tmpRes != null) {
                        parseResponse(tmpRes)
                        Timber.e(tmpRes.toString())
                    }
                }
            } else result = false

            result
        }
    }

    suspend fun isNotSyncData(): Boolean {
        return withContext(Dispatchers.IO) {
            var result = false

            try {
                if (
                    contactWireDao.countIsNotSync() != 0 ||
                    carrierWireDao.countIsNotSync() != 0 ||
                    canopyDao.countIsNotSyncCreated() != 0 ||
                    canopyDao.countIsNotSyncEdited() != 0 ||
                    dimensionsFenceDao.countIsNotSyncCreated() != 0 ||
                    dimensionsFenceDao.countIsNotSyncEdited() != 0 ||
                    createMeasurementsDao.countIsNotSyncCreated() != 0 ||
                    createMeasurementsDao.countIsNotSyncEdited() != 0 ||
                    platformDao.countIsNotSyncEdited() != 0
                ) {
                    result = true
                }
            } catch (e: java.lang.Exception) {
                result = true
            }

            result
        }
    }

    suspend fun removeAll(): Boolean {
        return withContext(Dispatchers.IO) {
            var result = true

            try {
                railwayDao.deleteAll()
                railwaySectionDao.deleteAll()
                stationPeregonDao.deleteAll()
                platformDao.deleteAll()
                supportDao.deleteAll()
                createMeasurementsDao.deleteAll()
                bridgeCrossingDao.deleteAll()
                dimensionsFenceDao.deleteAll()
                canopyDao.deleteAll()
                contactWireDao.deleteAll()
                carrierWireDao.deleteAll()

            } catch (e: java.lang.Exception) {
                Timber.e(" syncRepository removeAll: ${e.message}")
                result = false
            }

            result
        }
    }

    @SuppressLint("LogNotTimber")
    private suspend fun upload(): Boolean {
        val listBridgesCreated: List<BridgeCrossing> =
            bridgeCrossingDao.getBridgeCreated()

        val listBridgesEdited: List<BridgeCrossing> =
            bridgeCrossingDao.getBridgeCreated()

        val listSupportCreated: List<Support> =
            supportDao.getSupportCreated()

        val listSupportEdited: List<Support> =
            supportDao.getSupportEdited()

        val listCarrierWireCreated: List<CarrierWire> =
            carrierWireDao.getCarrierWireCreated()

        val listContactWireCreated: List<ContactWire> =
            contactWireDao.getContactWireCreated()

        val listMeasurementsCreated: List<Measurement> =
            createMeasurementsDao.getMeasurementsCreated()

        val listMeasurementsEdited: List<Measurement> =
            createMeasurementsDao.getMeasurementsEdited()

        val listCanopiesEdited: List<Canopy> = canopyDao.getCanopiesEdited()
        val listCanopiesCreated: List<Canopy> = canopyDao.getCanopiesCreated()

        val listStations: List<StationPeregon> = stationPeregonDao.getEditedStations()

        val listPlatforms: List<Platform> = platformDao.getEditedPlatforms()

        val listDimensionsFenceCreated: List<DimensionsFence> =
            dimensionsFenceDao.getDimensionsCreated()

        val listDimensionsFenceEdited: List<DimensionsFence> =
            dimensionsFenceDao.getDimensionsEdited()


        return withContext(Dispatchers.IO) {
            var result = true
            try {

                syncPlatform(listPlatforms)
                Log.e("AA","11")
                syncBridges(listBridgesCreated, listBridgesEdited)
                Log.e("AA","22")
                syncSupport(listSupportCreated, listSupportEdited)
                Log.e("AA","33")
                syncDimensionFence(listDimensionsFenceCreated, listDimensionsFenceEdited)
                Log.e("AA","44")
                syncCanopies(listCanopiesCreated, listCanopiesEdited)
                Log.e("AA","55")
                syncCarrierWire(listCarrierWireCreated)
                Log.e("AA","66")
                syncContactWire(listContactWireCreated)
                Log.e("AA","77"+ listMeasurementsEdited.toString())
                syncMeasurement(listMeasurementsCreated, listMeasurementsEdited)
                Log.e("AA","88")
                syncStation(listStations)
                Log.e("AA","99")


            } catch (e: Exception) {
                Timber.e("SyncRepository upload: ${e.message}")
                result = false
            }
            result
        }
    }

    private fun parseResponse(response: SyncResponse) {
        val result = response.results[0]

        //  Timber.i("SyncRepository -> parseResponse -> user id(owner) ->${auth.getUserID()}")

        insertRailways(result.railway)
        insertRailwaySections(result.railwaysector)
        insertStations(result.station)
        insertSupports(result.supports)
        insertPlatforms(result.platforms)
        insertMeasurements(result.measurement)
        insertBridges(result.bridges)
        insertDimensionsFence(result.gabarittor)
        insertCanopy(result.gabaritnaves)
        insertContactWire(result.contactWire)
        insertCarrierWire(result.carrierWire)
        insertMeasurementType(result.measurementType)
    }

    private fun insertRailways(railwayList: List<Railway>) {
        try {
            railwayList.forEach { railway ->
                railwayDao.insertWithReplace(railway)
                // Timber.i("Add: $railway")
            }
        } catch (e: Exception) {
            Timber.e("SyncRepository insertRailway: ${e.message}")
        }
    }

    private fun insertRailwaySections(railwaySectionList: List<RailwaySection>) {
        try {
            railwaySectionList.forEach { railwaySection ->
                railwaySectionDao.insertWithReplace(railwaySection)
                //Timber.i("Add: $railwaySection")
            }
        } catch (e: Exception) {
            Timber.e("SyncRepository insertRailwaySection: ${e.message}")
        }
    }

    private fun insertStations(stationList: List<StationPeregon>) {
        try {
            stationList.forEach { station ->
                stationPeregonDao.insertWithReplace(station)
                //Timber.i("Add: $station")
            }
        } catch (e: Exception) {
            Timber.e("SyncRepository insertStation: ${e.message}")
        }
    }

    private fun insertSupports(supportList: List<Support>) {
        try {
            supportList.forEach { support ->
                supportDao.insertWithReplace(support)
                // Timber.i("Add: $support")
            }
        } catch (e: Exception) {
            Timber.e("SyncRepository insertSupport: ${e.message}")
        }
    }

    private fun insertPlatforms(platformList: List<Platform>) {
       // Log.e("QQQQQQQQ=", platformList.size.toString())
       // Log.e("QQQQQQQQ2=", platformList.toString())
        try {
            platformList.forEach { platform ->
                if (platform.owner == auth.getUserID()) {
                    platformDao.insertWithReplace(platform)
                     Timber.i("Add: $platform")
                }
            }
        } catch (e: Exception) {
            Timber.e("SyncRepository insertPlatforms: ${e.message}")
        }
    }

    private fun insertMeasurements(measurementList: List<Measurement>) {
        try {
            measurementList.forEach { measurement ->
                createMeasurementsDao.insert(measurement)
                // Timber.i("Add: $measurement")
            }
        } catch (e: Exception) {
            Timber.e("SyncRepository insertMeasurements: ${e.message}")
        }
    }

    private fun insertBridges(bridgeList: List<BridgeCrossing>) {
        try {
            bridgeList.forEach { bridge ->
                if (bridge.owner == auth.getUserID()) {
                    bridgeCrossingDao.insertWithReplace(bridge)
                    //Timber.i("Add: $bridge")
                }
            }
        } catch (e: Exception) {
            Timber.e("SyncRepository insertBridges: ${e.message}")
        }
    }

    private fun insertDimensionsFence(dimensionsList: List<DimensionsFence>) {
        try {
            dimensionsList.forEach { dimension ->
                dimensionsFenceDao.insertWithReplace(dimension)
                //Timber.i("Add: $dimension")
            }
        } catch (e: Exception) {
            Timber.e("SyncRepository insertDimensionsFence: ${e.message}")
        }
    }

    private fun insertCanopy(canopiesList: List<Canopy>) {
        try {
            canopiesList.forEach { canopy ->
                canopyDao.insertWithReplace(canopy)
                //  Timber.i("Add: $canopy")
            }
        } catch (e: Exception) {
            Timber.e("SyncRepository insertCanopy: ${e.message}")
        }
    }

    private fun insertContactWire(contactWireList: List<ContactWire>) {
        try {
            contactWireList.forEach { contactWire ->
                contactWireDao.insertWithReplace(contactWire)
                //Timber.i("Add: $contactWire")
            }
        } catch (e: Exception) {
            Timber.e("SyncRepository insertContactWire: ${e.message}")
        }
    }

    private fun insertCarrierWire(carrierWireList: List<CarrierWire>) {
        try {
            carrierWireList.forEach { carrierWire ->
                carrierWireDao.insertWithReplace(carrierWire)
                // Timber.i("Add: $carrierWire")
            }
        } catch (e: Exception) {
            Timber.e("SyncRepository insertCarrierWire: ${e.message}")
        }
    }

    private fun insertMeasurementType(measurementTypeList: List<MeasurementType>) {
        try {
            measurementTypeList.forEach { measurementType ->
                measurementTypeDao.insertWithReplace(measurementType)
                // Timber.i("Add: $measurementType")
            }
        } catch (e: Exception) {
            Timber.e("SyncRepository insertMeasurementType: ${e.message}")
        }
    }

    private suspend fun syncPlatform(listPlatforms: List<Platform>) {
        listPlatforms.forEach { platfrom ->
            //Log.e("syncPlatform RT:", "$platfrom")
            val response = platformApi.update(
                platfrom.uid,
                PlatformRequest(
                    platfrom.uid,
                    platfrom.number,
                    platfrom.way_number,
                    platfrom.km_way,
                    platfrom.picket,
                    platfrom.type1,
                    platfrom.type2,
                    platfrom.comment,
                    platfrom.photo1,
                    platfrom.photo2,
                    platfrom.type_gabarits_uid,
                    platfrom.type_platform_uid
                )
            )
            if (!response.isSuccessful) {
                Timber.e(response.errorBody().toString())
                throw Exception("${response.code()}:${response.message()}")
            }
            platformDao.updateFlagEdited(platfrom.uid, false)
        }
    }


    private suspend fun syncContactWire(listContactWire: List<ContactWire>) {
        listContactWire.forEach { contactWire ->
            //  Log.e("syncContactWire RT:", "$contactWire")
            val response = contactWireApi.update(
                ContactWireRequest(
                    contactWire.uid,
                    contactWire.opora_uid,
                    contactWire.type_height_wire_uid,
                    contactWire.type_height_wire_uid
                )
            )
            if (!response.isSuccessful) {
                Timber.e(response.errorBody().toString())
                throw Exception("${response.code()}:${response.message()}")
            }
            contactWireDao.updateFlagCreated(contactWire.uid, false)
        }
    }

    private suspend fun syncCarrierWire(listCarrierWire: List<CarrierWire>) {
        listCarrierWire.forEach { carrierWire ->
            // Log.e("syncCarrierWire RT:", "$carrierWire")
            val response = carrierWireApi.create(
                CarrierWireRequest(
                    carrierWire.uid,
                    carrierWire.opora_uid,
                    carrierWire.type_height_wire_uid,
                    carrierWire.type_height_wire_uid
                )
            )
            if (!response.isSuccessful) {
                Timber.e(response.errorBody().toString())
                throw Exception("${response.code()}:${response.message()}")
            }
            carrierWireDao.updateFlagCreated(carrierWire.uid, false)
        }
    }

    private suspend fun syncBridges(
        listBridgeCreate: List<BridgeCrossing>,
        listBridgeEdited: List<BridgeCrossing>
    ) {
        listBridgeCreate.forEach { bridge ->
            //Log.e("syncBridges REQUEST:", "$bridge")
            val response = bridgeApi.create(bridge)

            if (!response.isSuccessful) {
                Timber.e(response.errorBody().toString())
                throw Exception("${response.code()}:${response.message()}")
            }

            bridgeCrossingDao.updateFlagCreated(bridge.uid, false)
        }
    }

    private suspend fun syncSupport(
        listSupportCreate: List<Support>,
        listSupportEdited: List<Support>
    ) {
        listSupportCreate.forEach { support ->
            //Log.e("syncSupport REQUEST:", "$support")
            val response = supportApi.supportCreate(support)
            if (!response.isSuccessful) {

                Timber.e(response.errorBody().toString())
                throw Exception("${response.code()}:${response.message()}")
            }

            supportDao.updateFlagCreated(support.uid, false)
        }

        listSupportEdited.forEach { support ->

            val response = supportApi.supportUpdate(
                support.uid,
                support
            )
            if (!response.isSuccessful) {
                Timber.e(response.errorBody().toString())
                throw Exception("${response.code()}:${response.message()}")
            }
            dimensionsFenceDao.updateFlagEdited(support.uid, false)
        }
    }

    private suspend fun syncDimensionFence(
        listDimensionsFenceCreate: List<DimensionsFence>,
        listDimensionsFenceUpdate: List<DimensionsFence>
    ) {
        listDimensionsFenceCreate.forEach { dimension ->
            //Log.e("syncDimensionF REQUEST:", "$dimension")
            val response = dimensionFenceAPI.create(
                DimensionsFenceRequest(
                    dimension.uid, dimension.platform_uid, dimension.direction
                )
            )
            if (!response.isSuccessful) {
                Timber.e(response.errorBody().toString())
                throw Exception("${response.code()}:${response.message()}")
            }

            dimensionsFenceDao.updateFlagCreated(dimension.uid, false)
        }

        listDimensionsFenceUpdate.forEach { dimension ->
            // Log.e("syncDimensionF REQUEST:", "$dimension")
            val response = dimensionFenceAPI.update(
                dimension.uid,
                DimensionsFenceRequest(
                    dimension.uid, dimension.platform_uid, dimension.direction
                )
            )
            if (!response.isSuccessful) {
                Timber.e(response.errorBody().toString())
                throw Exception("${response.code()}:${response.message()}")
            }
            dimensionsFenceDao.updateFlagEdited(dimension.uid, false)
        }
    }

    private suspend fun syncStation(listStation: List<StationPeregon>) {
        listStation.forEach { station ->
            // Log.e("syncStation REQUEST:", "$station")
            val response = stationApi.update(
                station.uid,
                StationRequest(station.photo1, station.photo2, station.comment)
            )
            if (!response.isSuccessful) {
                Timber.e(response.errorBody().toString())
                throw Exception("${response.code()}:${response.message()}")
            }
            stationPeregonDao.updateFlagEdited(station.uid, false)
        }
    }

    private suspend fun syncCanopies(
        listCanopiesCreated: List<Canopy>,
        listCanopiesEdited: List<Canopy>
    ) {

        //create with empty north_uid south_uid center_uid
        listCanopiesCreated.forEach { canopy ->
            // Log.e("syncCanopies REQUEST:", "$canopy")
            var response = canopyApi.create(
                CanopyRequest(
                    canopy.uid,
                    canopy.platform_uid,
                    null,
                    null,
                    null
                )
            )
            if (!response.isSuccessful) {
                Timber.e(response.errorBody().toString())
                throw Exception("${response.code()}:${response.message()}")
            }

            canopyDao.updateFlagCreated(canopy.uid, false)
        }


        listCanopiesEdited.forEach { canopy ->
            //Log.e("syncCanopies REQUEST:", "$canopy")
            val response = canopyApi.update(
                canopy.uid,
                CanopyRequest(
                    canopy.uid,
                    canopy.platform_uid,
                    canopy.north_uid,
                    canopy.south_uid,
                    canopy.center_uid
                )
            )
            if (!response.isSuccessful) {
                Timber.e(response.errorBody().toString())
                throw Exception("${response.code()}:${response.message()}")
            }
            canopyDao.updateFlagEdited(canopy.uid, false)
        }
    }

    private suspend fun syncMeasurement(
        listMeasurementCreate: List<Measurement>,
        listMeasurementUpdate: List<Measurement>
    ) {

        Log.e("CreateStart", "ssssssss")
        listMeasurementCreate.forEach { measurement ->
            // Log.e("syncMeasuremen REQUEST:", "$measurement")
            val response = createMeasurementsApi.create(
                MeasurementRequest(
                    measurement.uid,
                    measurement.gipotinuza,
                    measurement.ugol_naklona,
                    measurement.vertical_gabarit,
                    measurement.horizontal_gabarit,
                    measurement.km_way,
                    measurement.way_number,
                    measurement.picket,
                    measurement.radius,
                    measurement.vozvishenie,
                    measurement.comment,
                    measurement.photo1,
                    measurement.photo2,
                    measurement.parent_platform_uid,
                    measurement.parent_gabarit_naves_uid,
                    measurement.parent_gabarit_tor_uid,
                    measurement.parent_main_wire_uid,
                    measurement.parent_contact_wire_uid,
                    measurement.parent_most_perehod_uid,
                    measurement.type_measurement_uid,
                    measurement.created_at
                )
            )
            if (!response.isSuccessful) {
                Timber.e(response.errorBody().toString())
                Log.e(response.errorBody().toString(), "ssssssss")
                throw Exception("${response.code()}:${response.message()}")
            }

            createMeasurementsDao.updateFlagCreated(measurement.uid, false)
        }

        Log.e("CreateSuccess", "ssssssss")

        listMeasurementUpdate.forEach { measurement ->
             Log.e("syncMeasure REQUEST:", "$measurement")
            val response = createMeasurementsApi.update(
                measurement.uid,
                MeasurementRequest(
                    measurement.uid,
                    measurement.gipotinuza,
                    measurement.ugol_naklona,
                    measurement.vertical_gabarit,
                    measurement.horizontal_gabarit,
                    measurement.km_way,
                    measurement.way_number,
                    measurement.picket,
                    measurement.radius,
                    measurement.vozvishenie,
                    measurement.comment,
                    measurement.photo1,
                    measurement.photo2,
                    measurement.parent_platform_uid,
                    measurement.parent_gabarit_naves_uid,
                    measurement.parent_gabarit_tor_uid,
                    measurement.parent_main_wire_uid,
                    measurement.parent_contact_wire_uid,
                    measurement.parent_most_perehod_uid,
                    measurement.type_measurement_uid,
                    measurement.created_at
                )
            )
            if (!response.isSuccessful) {
                Timber.e(response.errorBody().toString())
                throw Exception("${response.code()}:${response.message()}")
            }
            createMeasurementsDao.updateFlagEdited(measurement.uid, false)
        }
    }
}
