package dev.fabula.android.wire.contact.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.fabula.android.wire.carrier.model.CarrierWire
import dev.fabula.android.wire.contact.model.ContactWire

@Dao
interface ContactWireDao {

    @Query("DELETE FROM contact_wire")
    fun deleteAll()

    @Query("DELETE FROM contact_wire WHERE uid = :uid")
    fun deleteById(uid: String)


    @Query("UPDATE contact_wire SET flag_created = :flag WHERE uid =:uid")
    fun updateFlagCreated(uid: String, flag: Boolean)

    @Query("SELECT count(uid) FROM contact_wire WHERE opora_uid=:uidParent")
    fun getCountContactWireOfSupport(
        uidParent: String
    ): Int

    @Query("SELECT count(uid) FROM contact_wire WHERE flag_created=:flag_created")
    fun countIsNotSync(flag_created: Boolean = true): Int

    @Query("SELECT * FROM contact_wire WHERE opora_uid=:uidParent")
    fun getContactWireOfSupport(
        uidParent: String
    ): ContactWire

    @Query("SELECT * FROM contact_wire WHERE flag_created=:flag_created")
    fun getContactWireCreated(flag_created: Boolean = true): List<ContactWire>

    @Insert
    fun insert(contactWire: ContactWire)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(contactWire: ContactWire)
}