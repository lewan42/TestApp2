package dev.fabula.android.dimensions.fence.repo

import android.util.Log
import androidx.annotation.WorkerThread
import dev.fabula.android.app.util.Util
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao
import dev.fabula.android.dimensions.fence.model.DimensionSaveDB
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.dimensions.fence.model.DimensionsWithMeasure
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao
import dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule
import dev.fabula.android.platform.dao.PlatformDao
import dev.fabula.android.platform.model.Platform
import java.util.*
import javax.inject.Inject

class DimensionsFenceRepository @Inject constructor(
    private val platformDao: PlatformDao,
    private val dimensionsFenceDao: DimensionsFenceDao,
    private val createMeasurementsDao: CreateMeasurementsDao,
    private val measurementTypeDao: MeasurementTypeDao
) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getPlatformById(uidPlatform: String): Platform {
        return platformDao.getPlatformById(uidPlatform)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun autoCreateDimensions(uidPlatform: String, count: Int): Boolean {

        val countDimension = dimensionsFenceDao.getCountDimensionsOfPlatform(uidPlatform)

        Log.e("autoCreateDimensions: ", "$countDimension / $count")
        if (count == countDimension) return true
        else if (countDimension < count) {
            try {
                for (i in (count - countDimension - 1) downTo 0 step 1) {

                    dimensionsFenceDao.insertWithReplace(
                        DimensionsFence(
                            UUID.randomUUID().toString(),
                            uidPlatform,
                            "-",
                            true,
                            false
                        )
                    )
                }
            } catch (e: Exception) {
                return false
            }
            return true
        } else return false
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateDimension(list: List<DimensionSaveDB>): Boolean {
        return try {
            list.forEach {
                createMeasurementsDao.updateMeasurementOfDimension(it.uidD, it.v, it.g)
                dimensionsFenceDao.updateMeasurementOfDimension(it.uidD, it.dir)
            }
            return true
        } catch (e: Exception) {
            false
        }
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getDimensionList(uidPlatform: String): List<DimensionsWithMeasure> {
        val list: List<DimensionsFence> =
            dimensionsFenceDao.getDimensionsFenceOfPlatform(uidPlatform)
        val result: MutableList<DimensionsWithMeasure> = mutableListOf()

        val uidMeasurementType =
            measurementTypeDao.getTypeMeasurementByType(Util.dimensions_fence_type)

        list.forEach {
            Log.e("getDimensionList uid: ", it.uid)
            val measurementD = createMeasurementsDao.getMeasurementOfDimensionsFence(it.uid)

            if (measurementD != null) {
                result.add(
                    DimensionsWithMeasure(
                        it.uid,
                        it.platform_uid,
                        it.direction,
                        measurementD.vertical_gabarit,
                        measurementD.horizontal_gabarit,
                        measurementD.uid,
                        uidMeasurementType.uid
                    )
                )
            } else {
                result.add(
                    DimensionsWithMeasure(
                        it.uid,
                        it.platform_uid,
                        it.direction,
                        null,
                        null,
                        null,
                        uidMeasurementType.uid
                    )
                )
            }
        }
        Log.e("getDimensionList r:", result.toString())
        return result
    }
}