package dev.fabula.android.station.peregon.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.station.peregon.dao.StationPeregonDao

@Module
class StationPeregonModuleDao {

    @Provides
    fun providesStationPeregonDAO(appDatabase: AppRoomDatabase): StationPeregonDao {
        return appDatabase.stationPeregonDao()
    }
}