package dev.fabula.android.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.fabula.android.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun all(): List<User?>?

    @Query("SELECT COUNT(*) from user")
    fun count(): Int

    @Insert
    fun insert(vararg users: User?)
}