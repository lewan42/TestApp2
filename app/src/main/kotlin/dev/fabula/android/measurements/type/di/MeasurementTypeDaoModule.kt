package dev.fabula.android.measurements.type.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao

@Module
class MeasurementTypeDaoModule {

    @Provides
    fun providesMeasurementTypeDAO(appDatabase: AppRoomDatabase): MeasurementTypeDao {
        return appDatabase.measurementTypeDao()
    }
}