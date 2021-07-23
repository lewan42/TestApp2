package dev.fabula.android.dimensions.fence.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao

@Module
class DimensionsFenceDaoModule {

    @Provides
    fun providesDimensionsDAO(appDatabase: AppRoomDatabase): DimensionsFenceDao {
        return appDatabase.dimensionsFenceDao()
    }
}