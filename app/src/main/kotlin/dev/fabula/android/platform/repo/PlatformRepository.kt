package dev.fabula.android.platform.repo

import android.util.Log
import androidx.annotation.WorkerThread
import dev.fabula.android.app.util.Util
import dev.fabula.android.canopy.dao.CanopyDao
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.dimensions.fence.model.DimensionsWithMeasure
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao
import dev.fabula.android.platform.dao.PlatformDao
import dev.fabula.android.platform.model.Platform
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class PlatformRepository @Inject constructor(
    private val platformDao: PlatformDao,
    private val canopyDao: CanopyDao,
    private val dimensionsFenceDao: DimensionsFenceDao,
    private val createMeasurementsDao: CreateMeasurementsDao,
    private val measurementTypeDao: MeasurementTypeDao
) {

    val allPlatforms: Flow<List<Platform>> = platformDao.getAllPlatforms()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getPlatformsOfStationOrPeregon(uid: String): List<Platform> {
        return platformDao.getPlatformsOfStationOrPeregon(uid)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getPlatformById(uidPlatform: String): Platform {
        return platformDao.getPlatformById(uidPlatform)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getCanopyOfPlatform(uidPlatform: String): Canopy {

        return if (canopyDao.isExists(uidPlatform)) {
            canopyDao.getCanopyOfParent(uidPlatform)
        } else {
            val canopy =
                Canopy(UUID.randomUUID().toString(), uidPlatform, null, null, null, true, false)
            canopyDao.insert(canopy)
            canopy
        }
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getDimensionFences(
        uidPlatform: String,
        countDimensionsFence: Int
    ): List<DimensionsFence> {

        return if (dimensionsFenceDao.isExists(uidPlatform)) {
            dimensionsFenceDao.getDimensionsFenceOfPlatform(uidPlatform)
        } else {
            mutableListOf()
//            val resultList = mutableListOf<DimensionsFence>()
//            for (i in 1..countDimensionsFence) {
//                val dimensionsFence =
//                    DimensionsFence(
//                        UUID.randomUUID().toString(),
//                        uidPlatform,
//                        "",
//                        null,
//                        null
//                    )
//                dimensionsFenceDao.insert(dimensionsFence)
//                resultList.add(dimensionsFence)
//            }
//            resultList
        }
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    @Deprecated(message = "Метод не используется после изменения отображения габаритов торцевого ограждения")
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

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun platformUpdate(
        uidPlatform: String,
        numberWay: String,
        kmWay: String,
        picket: String,
        type1: String,
        type2: String,
        photo1: String?,
        photo2: String?,
        comment: String,
        flag_edited: Boolean
    ): Boolean {
        try {
            platformDao.update(
                uidPlatform,
                numberWay,
                kmWay,
                picket,
                type1,
                type2,
                photo1,
                photo2,
                comment,
                flag_edited
            )
        } catch (e: Exception) {
            return false
        }
        return true
    }
}