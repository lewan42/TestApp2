package dev.fabula.android.dimensions.fence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.platform.model.Platform

@Dao
interface DimensionsFenceDao {

    @Query("DELETE FROM gabarittor")
    fun deleteAll()

    @Query("SELECT * FROM gabarittor WHERE flag_created=:flag_created")
    fun getDimensionsCreated(flag_created: Boolean = true): List<DimensionsFence>

    @Query("SELECT * FROM gabarittor WHERE flag_edited=:flag_edited and flag_created is null")
    fun getDimensionsEdited(
        flag_edited: Boolean = true
    ): List<DimensionsFence>

    @Query("SELECT count(uid) FROM gabarittor WHERE flag_created=:flag_created")
    fun countIsNotSyncCreated(flag_created: Boolean = true): Int

    @Query("SELECT count(uid) FROM gabarittor WHERE flag_edited=:flag_edited")
    fun countIsNotSyncEdited(flag_edited: Boolean = true): Int

    @Query("SELECT * FROM gabarittor WHERE platform_uid=:uidPlatform")
    fun getDimensionsFenceOfPlatform(uidPlatform: String): List<DimensionsFence>

    @Query("UPDATE gabarittor SET direction = :direction WHERE uid =:uid")
    fun updateMeasurementOfDimension(uid: String, direction: String)

    @Query("SELECT count(uid) FROM gabarittor WHERE platform_uid=:uidParent")
    fun getCountDimensionsOfPlatform(
        uidParent: String
    ): Int

    @Query("DELETE FROM gabarittor WHERE uid = :uid")
    fun deleteById(uid: String)

    @Query("UPDATE gabarittor SET flag_created = :flag WHERE uid =:uid")
    fun updateFlagCreated(uid: String, flag: Boolean)

    @Query("UPDATE gabarittor SET flag_edited = :flag WHERE uid =:uid")
    fun updateFlagEdited(uid: String, flag: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(dimensionsFence: DimensionsFence)
}