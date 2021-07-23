package dev.fabula.android.measurements.create.repo

import androidx.annotation.WorkerThread
import dev.fabula.android.canopy.dao.CanopyDao
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.measurements.create.api.CreateMeasurementsApi
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao
import dev.fabula.android.measurements.model.Measurement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class CreateMeasurementsRepository @Inject constructor(
    private val createMeasurementsDao: CreateMeasurementsDao,
    private val canopyDao: CanopyDao,
    private val dimensionsFenceDao: DimensionsFenceDao
) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getMeasurementById(uid: String): Measurement {
        return createMeasurementsDao.getMeasurementById(uid)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertAll(measurements: List<Measurement>): Boolean {
        try {
            createMeasurementsDao.insertAll(measurements)
        } catch (e: Exception) {
            Timber.e("create measurement insertAll: ${e.message}")
            return false
        }
        return true
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(measurement: Measurement): Boolean {
        try {
            createMeasurementsDao.insert(measurement)
        } catch (e: Exception) {
            Timber.e("create measurement insert: ${e.message}")
            return false
        }
        return true
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertDimensionAndMeasurement(
        measurement: Measurement,
        dimensionsFence: DimensionsFence
    ): Boolean {
        try {

            Timber.e("insertDimensionAndMeasurement")
            dimensionsFenceDao.insertWithReplace(
                dimensionsFence
            )

            createMeasurementsDao.insert(
                Measurement(
                    measurement.uid,
                    measurement.gipotinuza,
                    measurement.ugol_naklona,
                    measurement.vertical_gabarit,
                    measurement.horizontal_gabarit,
                    measurement.lat,
                    measurement.lng,
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
                    dimensionsFence.uid,
                    measurement.parent_main_wire_uid,
                    measurement.parent_contact_wire_uid,
                    measurement.parent_most_perehod_uid,
                    measurement.type_measurement_uid,
                    measurement.flag_created,
                    measurement.flag_edited,
                    measurement.created_at
                )
            )
        } catch (e: Exception) {
            Timber.e("insertDimensionAndMeasurement catch: ${e.message}")
            return false
        }
        return true
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(measurement: Measurement): Boolean {
        try {
            createMeasurementsDao.insert(measurement)
        } catch (e: Exception) {
            return false
        }
        return true
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateCanopyNorth(uidCanopy: String, uidMeasurement: String): Boolean {
        try {
            canopyDao.updateCanopyNorth(uidCanopy, uidMeasurement)
        } catch (e: Exception) {
            Timber.e("updateCanopyNorth ${e.message}")
            return false
        }
        return true
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateCanopyCenter(uidCanopy: String, uidMeasurement: String): Boolean {
        try {
            canopyDao.updateCanopyCenter(uidCanopy, uidMeasurement)
        } catch (e: Exception) {
            Timber.e("updateCanopyCenter ${e.message}")
            return false
        }
        return true
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateCanopySouth(uidCanopy: String, uidMeasurement: String): Boolean {
        try {
            canopyDao.updateCanopySouth(uidCanopy, uidMeasurement)
        } catch (e: Exception) {
            Timber.e("updateCanopySouth ${e.message}")
            return false
        }
        return true
    }
}