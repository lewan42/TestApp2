package dev.fabula.android.bosch.otg.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.bosch.otg.data.source.BoschOtgDataSource
import dev.fabula.android.bosch.otg.file.BoschFileOtg

@Module
class BoschOtgModuleDataSource {

    @Provides
    fun providesBoschOtgDAO(): BoschOtgDataSource {
        return BoschFileOtg()
    }
}