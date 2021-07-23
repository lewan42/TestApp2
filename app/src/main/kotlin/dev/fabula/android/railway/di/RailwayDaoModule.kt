package dev.fabula.android.railway.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.railway.dao.RailwayDao

@Module
class RailwayDaoModule {

    @Provides
    fun providesRailwayDAO(appDatabase: AppRoomDatabase): RailwayDao {
        return appDatabase.railwayDao()
    }
}