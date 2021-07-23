package dev.fabula.android.platform.repo

import androidx.annotation.WorkerThread
import dev.fabula.android.canopy.dao.CanopyDao
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.measurements.type.model.MeasurementType
import dev.fabula.android.platform.dao.PlatformDao
import dev.fabula.android.platform.di.PlatformDaoModule
import dev.fabula.android.platform.model.Platform
import dev.fabula.android.station.peregon.model.StationPeregon
import dev.fabula.android.support.dao.SupportDao
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import java.lang.Exception
import java.util.*
import javax.inject.Inject

class PlatformRepository @Inject constructor(
    private val platformDao: PlatformDao,
    private val canopyDao: CanopyDao,
    private val supportDao: SupportDao

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
        try {
            if (canopyDao.isExists(uidPlatform)) {
                return canopyDao.getCanopyOfParent(uidPlatform)
            } else {
                val canopy =
                    Canopy(UUID.randomUUID().toString(), uidPlatform, null, null, null, true, false)
                canopyDao.insert(canopy)
                Timber.e("$canopy")
                return canopy
            }

        } catch (e: Exception) {

            val canopy =
                Canopy(UUID.randomUUID().toString(), uidPlatform, null, null, null, true, false)
            canopyDao.insert(canopy)
            Timber.e("$canopy")
            return canopy
        }
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