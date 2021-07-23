package dev.fabula.android.bosch.otg.data.source

import android.content.Context
import dev.fabula.android.bosch.otg.model.BoschOtgItemList
import java.io.File

interface BoschOtgDataSource {

    suspend fun getMeasurementsFromBoschDevice(file: File, context: Context): List<BoschOtgItemList>
}