package dev.fabula.android.wire.carrier.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.wire.carrier.dao.CarrierWireDao

@Module
class CarrierWireDaoModule {

    @Provides
    fun providesCarrierWireDAO(appDatabase: AppRoomDatabase): CarrierWireDao {
        return appDatabase.carrierWireDao()
    }
}