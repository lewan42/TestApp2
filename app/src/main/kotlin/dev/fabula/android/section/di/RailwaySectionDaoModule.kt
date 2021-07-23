package dev.fabula.android.section.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.section.dao.RailwaySectionDao

@Module
class RailwaySectionDaoModule {

    @Provides
    fun providesRailwaySectionDAO(appDatabase: AppRoomDatabase): RailwaySectionDao {
        return appDatabase.railwaySectionDao()
    }
}