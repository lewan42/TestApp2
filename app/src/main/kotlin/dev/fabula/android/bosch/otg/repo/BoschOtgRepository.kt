package dev.fabula.android.bosch.otg.repo

import android.content.Context
import androidx.annotation.WorkerThread
import dev.fabula.android.bosch.otg.data.source.BoschOtgDataSource
import dev.fabula.android.bosch.otg.model.BoschOtgItemList
import java.io.File
import javax.inject.Inject

class BoschOtgRepository @Inject constructor(
    private val boschOtgDao: BoschOtgDataSource
) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getDataFromBoschDevice(file: File, context: Context): List<BoschOtgItemList> {
        return boschOtgDao.getMeasurementsFromBoschDevice(file, context)
    }
}