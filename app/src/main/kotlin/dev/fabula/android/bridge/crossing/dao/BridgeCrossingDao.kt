package dev.fabula.android.bridge.crossing.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.fabula.android.bridge.crossing.model.BridgeCrossing

@Dao
interface BridgeCrossingDao {

    @Query("DELETE FROM bridge")
    fun deleteAll()

    @Query("SELECT * FROM bridge WHERE platform_uid=:uidParent")
    fun getBridgesCrossing(uidParent: String): List<BridgeCrossing>

    @Query("SELECT name FROM bridge WHERE uid=:uidBridge")
    fun getBridgeName(uidBridge: String): String

    @Query("SELECT * FROM bridge WHERE flag_created=:flag_created")
    fun getBridgeCreated(flag_created: Boolean = true): List<BridgeCrossing>

    @Query("SELECT * FROM bridge WHERE flag_edited=:flag_edited and flag_created is null")
    fun getBridgeEdited(
        flag_edited: Boolean = true
    ): List<BridgeCrossing>

    @Query("UPDATE bridge SET flag_created = :flag WHERE uid =:uid")
    fun updateFlagCreated(uid: String, flag: Boolean)

    @Query("UPDATE bridge SET flag_edited = :flag WHERE uid =:uid")
    fun updateFlagEdited(uid: String, flag: Boolean)

    @Insert()
    fun insert(bridgeCrossing: BridgeCrossing)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(bridgeCrossing: BridgeCrossing)
}