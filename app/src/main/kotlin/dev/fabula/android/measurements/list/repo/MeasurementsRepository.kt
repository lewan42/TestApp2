package dev.fabula.android.measurements.list.repo

import androidx.annotation.WorkerThread
import dev.fabula.android.canopy.dao.CanopyDao
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.dimensions.fence.model.DimensionsFenceWithMeasurement
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao
import dev.fabula.android.measurements.type.model.MeasurementType
import java.util.*
import javax.inject.Inject

class MeasurementsRepository @Inject constructor(
    private val createMeasurementsDao: CreateMeasurementsDao,
    private val canopyDao: CanopyDao,
    private val typeMeasurementsDao: MeasurementTypeDao
) {


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getTypeMeasurementByType(typeOf: String): MeasurementType {
        return typeMeasurementsDao.getTypeMeasurementByType(typeOf)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getMeasurementsOfPlatform(uid: String): List<Measurement> {
        return createMeasurementsDao.getMeasurementsOfPlatform(uid)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getCountLastMeasurementsOfPlatform(uid: String, count: Int): List<Measurement> {
        return createMeasurementsDao.getCountLastMeasurementsOfPlatform(uid, count)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getCountLastMeasurementsOfBridge(uid: String, count: Int): List<Measurement> {
        return createMeasurementsDao.getCountLastMeasurementsOfBridge(uid, count)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getCountLastMeasurementsOfDimensionsFence(
        dimensionFences: List<DimensionsFence>,
        count: Int
    ): List<DimensionsFenceWithMeasurement> {

        val resultList = mutableListOf<DimensionsFenceWithMeasurement>()

        dimensionFences.forEach { df ->
            val measurements =
                createMeasurementsDao.getCountLastMeasurementsOfDimensionsFence(df.uid, count)
            measurements.forEach {measure ->
                resultList.add(DimensionsFenceWithMeasurement(df, measure))
            }
        }

        return resultList
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getCountLastMeasurementsOfCanopy(uid: String, count: Int): List<Measurement> {
        return createMeasurementsDao.getCountLastMeasurementsOfCanopy(uid, count)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getMeasurementsOfBridge(uid: String): List<Measurement> {
        return createMeasurementsDao.getMeasurementsOfBridge(uid)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getCanopiesOfPlatform(uidPlatform: String): List<Canopy> {
        return canopyDao.getCanopiesOfParent(uidPlatform)
    }


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getMeasurementsOfCanopy(uid: String): List<Measurement> {
        return createMeasurementsDao.getMeasurementsOfCanopy(uid)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createCanopy(uidPlatform: String): String? {
        try {
            val uidCanopy = UUID.randomUUID().toString()
            canopyDao.insert(Canopy(uidCanopy, uidPlatform, null, null, null, true, false))
            return uidCanopy
        } catch (e: Exception) {
            return null
        }
    }
}