package dev.fabula.android.measurements.union.list.repo

import android.content.Context
import android.util.Log
import androidx.annotation.WorkerThread
import dev.fabula.android.bosch.otg.data.source.BoschOtgDataSource
import dev.fabula.android.bosch.otg.model.BoschOtgItemList
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao
import dev.fabula.android.measurements.model.Measurement
import java.io.File
import java.lang.Exception
import javax.inject.Inject

class UnionMeasurementsRepository @Inject constructor(
    private val createMeasurementsDao: CreateMeasurementsDao,
    private val boschOtgDao: BoschOtgDataSource
) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getCreatedMeasurement(): List<Measurement> {
        return createMeasurementsDao.getMeasurementsCreated()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getDataFromBoschDevice(file: File, context: Context): List<BoschOtgItemList> {
        return boschOtgDao.getMeasurementsFromBoschDevice(file, context)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updatePhotoZamer(uid: String, photo: String): Boolean {
        return try {
            createMeasurementsDao.updatePhotoZamer(uid, photo)
            true
        } catch (e: Exception) {
            Log.e("UnionMeasurementsRepo", "updatePhotoZamer")
            false
        }
    }
}