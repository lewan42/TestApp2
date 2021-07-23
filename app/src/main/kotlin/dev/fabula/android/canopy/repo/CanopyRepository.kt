package dev.fabula.android.canopy.repo

import androidx.annotation.WorkerThread
import dev.fabula.android.canopy.dao.CanopyDao
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao
import dev.fabula.android.measurements.model.Measurement
import timber.log.Timber
import javax.inject.Inject

class CanopyRepository @Inject constructor(
    private val canopyDao: CanopyDao,
    private val createMeasurementsDao: CreateMeasurementsDao
) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getCanopyById(uidPlatform: String): Canopy {
        return canopyDao.getCanopyById(uidPlatform)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getMeasurementsOfCanopy(uidCanopy: String): List<Measurement> {
        return createMeasurementsDao.getMeasurementsOfCanopy(uidCanopy)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateMeasurementOfCanopy(
        uidCanopy: String,
        uid1: String, v1: String, h1: String,
        uid2: String, v2: String, h2: String,
        uid3: String, v3: String, h3: String
    ): Boolean {
        return try {
            createMeasurementsDao.updateMeasurementOfCanopy(
                uid1,
                v1,
                h1,
                uid2,
                v2,
                h2,
                uid3,
                v3,
                h3
            )

            canopyDao.updateFlagEditable(uidCanopy)
            return true
        } catch (e: Exception) {
            Timber.e("CanopyRepository updateMeasurementOfCanopy: ${e.message}")
            false
        }
    }
}