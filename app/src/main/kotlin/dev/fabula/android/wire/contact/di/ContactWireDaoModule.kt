package dev.fabula.android.wire.contact.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.wire.contact.dao.ContactWireDao

@Module
class ContactWireDaoModule {

    @Provides
    fun providesContactWireDAO(appDatabase: AppRoomDatabase): ContactWireDao {
        return appDatabase.contactWireDao()
    }
}