package dev.fabula.android.measurements.create.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao

@Module
class CreateMeasurementsDaoModule {

    @Provides
    fun providesCreateMeasurementsDAO(appDatabase: AppRoomDatabase): CreateMeasurementsDao {
        return appDatabase.createMeasurementDao()
    }
}