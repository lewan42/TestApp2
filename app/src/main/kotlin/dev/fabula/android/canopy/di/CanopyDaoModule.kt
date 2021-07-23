package dev.fabula.android.canopy.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.canopy.dao.CanopyDao

@Module
class CanopyDaoModule {

    @Provides
    fun providesPlatformDAO(appDatabase: AppRoomDatabase): CanopyDao {
        return appDatabase.canopyDao()
    }
}