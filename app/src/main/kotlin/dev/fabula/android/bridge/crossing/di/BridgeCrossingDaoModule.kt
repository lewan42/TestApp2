package dev.fabula.android.bridge.crossing.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao

@Module
class BridgeCrossingDaoModule {

    @Provides
    fun providesBridgeDAO(appDatabase: AppRoomDatabase): BridgeCrossingDao {
        return appDatabase.bridgeCrossingDao()
    }
}