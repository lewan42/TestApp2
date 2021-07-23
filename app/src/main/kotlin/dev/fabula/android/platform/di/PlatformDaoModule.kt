package dev.fabula.android.platform.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.platform.dao.PlatformDao

@Module
class PlatformDaoModule {

    @Provides
    fun providesPlatformDAO(appDatabase: AppRoomDatabase): PlatformDao {
        return appDatabase.platformDao()
    }
}