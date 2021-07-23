package dev.fabula.android.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.fabula.android.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}