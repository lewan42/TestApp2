package dev.fabula.android.support.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.support.dao.SupportDao

@Module
class SupportDaoModule {

    @Provides
    fun providesSupportDAO(appDatabase: AppRoomDatabase): SupportDao {
        return appDatabase.supportDao()
    }
}