package dev.fabula.android.app.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.bridge.crossing.model.BridgeCrossing
import dev.fabula.android.platform.model.Platform
import dev.fabula.android.railway.model.Railway
import dev.fabula.android.section.model.RailwaySection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

interface DatabaseProvider {
    fun providesRoomDatabase(): AppRoomDatabase
}

@Module
class DatabaseModule {

    lateinit var appDatabase: AppRoomDatabase

    private val databaseCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            CoroutineScope(Dispatchers.IO).launch {
            }
        }
    }

    @Provides
    fun providesRoomDatabase(context: Context): AppRoomDatabase {
        appDatabase =
            Room.databaseBuilder((context as BaseApp), AppRoomDatabase::class.java, "my_db")
                .fallbackToDestructiveMigration()
                .addCallback(databaseCallback)
                .build()
        return appDatabase
    }
}