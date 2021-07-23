package dev.fabula.android.support.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.fabula.android.bridge.crossing.model.BridgeCrossing
import dev.fabula.android.support.model.Support
import kotlinx.coroutines.flow.Flow

@Dao
interface SupportDao {

    @Query("DELETE FROM support")
    fun deleteAll()

    @Query("SELECT * FROM support")
    fun getSupports(): Flow<List<Support>>

    @Query("SELECT * FROM support WHERE uid=:uid")
    fun getSupportById(uid: String): Support

    @Query("SELECT * FROM support WHERE flag_created=:flag_created")
    fun getSupportCreated(flag_created: Boolean = true): List<Support>

    @Query("SELECT * FROM support WHERE flag_edited=:flag_edited and flag_created is null")
    fun getSupportEdited(
        flag_edited: Boolean = true
    ): List<Support>

    @Query("UPDATE support SET flag_created = :flag WHERE uid =:uid")
    fun updateFlagCreated(uid: String, flag: Boolean)

    @Query("UPDATE support SET flag_edited = :flag WHERE uid =:uid")
    fun updateFlagEdited(uid: String, flag: Boolean)

    // @Insert(onConflict = OnConflictStrategy.IGNORE)
    @Insert()
    fun insert(support: Support)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(support: Support)

    @Query("UPDATE support SET contact_wire = :uidContactWire, carrier_wire = :uidCarrierWire WHERE uid =:uidSupport")
    fun updateWires(uidSupport: String, uidContactWire: String, uidCarrierWire: String)

    @Query("UPDATE support SET number = :number, km_way = :kmWay,way_number = :wayNumber,picket = :picket,comment = :comment,photo1 = :photo1,photo2 = :photo2,flag_edited =:flag_edited WHERE uid =:uidSupport")
    fun update(
        uidSupport: String,
        number: String,
        kmWay: String,
        wayNumber: String,
        picket: String,
        comment: String?,
        photo1: String?,
        photo2: String?,
        flag_edited: Boolean = true
    )

    @Query("SELECT * FROM support WHERE parent_uid=:idParent and number LIKE '%' || :filterQuery || '%'")
    fun getListSupportsByIdAndQuery(
        idParent: String,
        filterQuery: String
    ): List<Support>

    @Query("SELECT * FROM support WHERE parent_uid=:uidParent")
    fun getSupportsOfParent(
        uidParent: String
    ): List<Support>
}