package dev.fabula.android.railway.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.fabula.android.railway.model.Railway
import kotlinx.coroutines.flow.Flow

@Dao
interface RailwayDao {

    @Query("SELECT * FROM railway")
    fun getRailways(): Flow<List<Railway>>

    @Insert()
    fun insert(railway: Railway)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(railway: Railway)

    @Query("DELETE FROM railway")
    fun deleteAll()
}