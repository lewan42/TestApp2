package dev.fabula.android.platform.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.fabula.android.platform.model.Platform
import kotlinx.coroutines.flow.Flow

@Dao
interface PlatformDao {

    @Query("SELECT * FROM platform")
    fun getAllPlatforms(): Flow<List<Platform>>

    @Query("SELECT * FROM platform WHERE station_uid=:uidStationPeregon")
    fun getPlatformsOfStationOrPeregon(uidStationPeregon: String): List<Platform>

    @Query("UPDATE platform SET flag_edited = :flag WHERE uid =:uid")
    fun updateFlagEdited(uid: String, flag: Boolean)

    @Query("SELECT * FROM platform WHERE flag_edited=:flag")
    fun getEditedPlatforms(flag: Boolean = true): List<Platform>

    @Query("SELECT * FROM platform WHERE station_uid=:uidStationPeregon")
    fun getListMeasurementOfPlatform(uidStationPeregon: String): List<Platform>

    @Query("SELECT * FROM platform WHERE uid=:uidPlatform")
    fun getPlatformById(uidPlatform: String): Platform

    @Query("SELECT count(uid) FROM platform WHERE flag_edited=:flag_edited")
    fun countIsNotSyncEdited(flag_edited: Boolean = true): Int

    @Insert()
    fun insert(platform: Platform)

    @Query("DELETE FROM platform WHERE uid = :uid")
    fun deleteById(uid: String)

    @Query("DELETE FROM platform")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(platform: Platform)

    @Query("SELECT number FROM platform WHERE uid=:uidPlatform")
    fun getPlatformName(uidPlatform: String): String

    @Query("UPDATE platform SET way_number = :numberWay, km_way = :kmWay, picket = :picket,type1=:type1, type2=:type2, photo1=:photo1, photo2=:photo2, comment=:comment,flag_edited=:flag_edited WHERE uid =:uidPlatform")
    fun update(
        uidPlatform: String,
        numberWay: String,
        kmWay: String,
        picket: String,
        type1: String,
        type2: String,
        photo1: String?,
        photo2: String?,
        comment: String,
        flag_edited: Boolean
    )
}