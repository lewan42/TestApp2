package dev.fabula.android.section.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.fabula.android.railway.model.Railway
import dev.fabula.android.section.model.RailwaySection
import kotlinx.coroutines.flow.Flow

@Dao
interface RailwaySectionDao {

    @Query("DELETE FROM railway_section")
    fun deleteAll()

    @Query("SELECT * FROM railway_section WHERE railway_uid=:uid_railway")
    fun getRailwaySections(uid_railway: String): List<RailwaySection>

    @Query("SELECT * FROM railway_section")
    fun getRailwaySections(): Flow<List<RailwaySection>>

    @Insert()
    fun insert(railwaySection: RailwaySection)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(railwaySection: RailwaySection)
}