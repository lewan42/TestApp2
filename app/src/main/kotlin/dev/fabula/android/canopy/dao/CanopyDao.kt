package dev.fabula.android.canopy.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.fabula.android.canopy.model.Canopy

@Dao
interface  CanopyDao {

    @Query("DELETE FROM canopy")
    fun deleteAll()

    @Query("DELETE FROM canopy WHERE uid = :uid")
    fun deleteById(uid: String)

    @Query("UPDATE canopy SET flag_created = :flag WHERE uid =:uid")
    fun updateFlagCreated(uid: String, flag: Boolean)

    @Query("UPDATE canopy SET flag_edited = :flag WHERE uid =:uid")
    fun updateFlagEdited(uid: String, flag: Boolean)

    @Query("UPDATE canopy SET flag_edited = :flag WHERE uid =:uid")
    fun updateFlagEditable(uid: String, flag: Boolean = true)

    @Insert()
    fun insert(canopy: Canopy)

    @Query("SELECT count(uid) FROM canopy WHERE flag_created=:flag_created")
    fun countIsNotSyncCreated(flag_created: Boolean = true): Int

    @Query("SELECT count(uid) FROM canopy WHERE flag_edited=:flag_edited")
    fun countIsNotSyncEdited(flag_edited: Boolean = true): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(canopy: Canopy)

    @Query("SELECT * FROM canopy")
    fun getAllCanopies(): List<Canopy>

    @Query("SELECT * FROM canopy WHERE flag_created=:flag_created")
    fun getCanopiesCreated(flag_created: Boolean = true): List<Canopy>

    @Query("SELECT * FROM canopy WHERE flag_edited=:flag_edited and flag_created is null")
    fun getCanopiesEdited(
        flag_edited: Boolean = true
    ): List<Canopy>

    @Query("SELECT * FROM canopy WHERE platform_uid=:uidParent")
    fun getCanopiesOfParent(uidParent: String): List<Canopy>

    @Query("SELECT * FROM canopy WHERE platform_uid=:uidParent")
    fun getCanopyOfParent(uidParent: String): Canopy

    @Query("SELECT EXISTS(SELECT * FROM canopy WHERE platform_uid=:uidParent)")
    fun isExists(uidParent: String): Boolean

    @Query("SELECT * FROM canopy WHERE uid=:uidCanopy")
    fun getCanopyById(uidCanopy: String): Canopy

    @Query("UPDATE canopy SET north_uid = :uidMeasurement WHERE uid =:uidCanopy")
    fun updateCanopyNorth(uidCanopy: String, uidMeasurement: String)

    @Query("UPDATE canopy SET center_uid = :uidMeasurement WHERE uid =:uidCanopy")
    fun updateCanopyCenter(uidCanopy: String, uidMeasurement: String)

    @Query("UPDATE canopy SET south_uid = :uidMeasurement WHERE uid =:uidCanopy")
    fun updateCanopySouth(uidCanopy: String, uidMeasurement: String)
}