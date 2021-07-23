package dev.fabula.android.wire.carrier.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.wire.carrier.model.CarrierWire
import dev.fabula.android.wire.contact.model.ContactWire

@Dao
interface CarrierWireDao {

    @Query("DELETE FROM carrier_wire")
    fun deleteAll()

    @Query("DELETE FROM carrier_wire WHERE uid = :uid")
    fun deleteById(uid: String)

    @Query("UPDATE carrier_wire SET flag_created = :flag WHERE uid =:uid")
    fun updateFlagCreated(uid: String, flag: Boolean)

    @Query("SELECT count(uid) FROM carrier_wire WHERE opora_uid=:uidParent")
    fun getCountCarrierWireOfSupport(
        uidParent: String
    ): Int

    @Query("SELECT count(uid) FROM carrier_wire WHERE flag_created=:flag_created")
    fun countIsNotSync(flag_created: Boolean = true): Int

    @Query("SELECT * FROM carrier_wire WHERE opora_uid=:uidParent")
    fun getCarrierWireOfSupport(
        uidParent: String
    ): CarrierWire


    @Query("SELECT * FROM carrier_wire WHERE flag_created=:flag_created")
    fun getCarrierWireCreated(flag_created: Boolean = true): List<CarrierWire>

    @Insert
    fun insert(carrierWire: CarrierWire)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(carrierWire: CarrierWire)

}