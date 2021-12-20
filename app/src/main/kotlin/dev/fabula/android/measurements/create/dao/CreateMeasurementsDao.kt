package dev.fabula.android.measurements.create.dao

import androidx.room.*
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.measurements.model.Measurement

@Dao
interface CreateMeasurementsDao {

    @Query("DELETE FROM measurement")
    fun deleteAll()

    @Query("DELETE FROM measurement WHERE uid = :uid")
    fun deleteById(uid: String)

    @Query("UPDATE measurement SET flag_created = :flag WHERE uid =:uid")
    fun updateFlagCreated(uid: String, flag: Boolean)

    @Query("UPDATE measurement SET photo1 = :photo1 WHERE uid =:uid")
    fun updatePhotoZamer(uid: String, photo1: String)

    @Query("UPDATE measurement SET flag_edited = :flag WHERE uid =:uid")
    fun updateFlagEdited(uid: String, flag: Boolean)

    @Query("SELECT count(uid) FROM measurement WHERE flag_created=:flag_created")
    fun countIsNotSyncCreated(flag_created: Boolean = true): Int

    @Query("SELECT count(uid) FROM measurement WHERE flag_edited=:flag_edited")
    fun countIsNotSyncEdited(flag_edited: Boolean = true): Int

    @Query("SELECT * FROM measurement")
    fun getMeasurements(): List<Measurement>

    @Query("SELECT * FROM measurement WHERE parent_platform_uid=:uidPlatform")
    fun getMeasurementsOfPlatform(uidPlatform: String): List<Measurement>

    @Query("select * from (select distinct DATE(created_at, 'unixepoch') as date from measurement order by date desc limit :count) sub join measurement m on sub.date = DATE(m.created_at, 'unixepoch') WHERE parent_platform_uid=:uidPlatform")
    fun getCountLastMeasurementsOfPlatform(uidPlatform: String, count: Int): List<Measurement>

    @Query("select * from (select distinct DATE(created_at, 'unixepoch') as date from measurement order by date desc limit :count) sub join measurement m on sub.date = DATE(m.created_at, 'unixepoch') WHERE parent_most_perehod_uid=:uidBridge")
    fun getCountLastMeasurementsOfBridge(uidBridge: String, count: Int): List<Measurement>

    @Query("select * from (select distinct DATE(created_at, 'unixepoch') as date from measurement order by date desc limit :count) sub join measurement m on sub.date = DATE(m.created_at, 'unixepoch') WHERE parent_gabarit_naves_uid=:uidCanopy")
    fun getCountLastMeasurementsOfCanopy(uidCanopy: String, count: Int): List<Measurement>

    @Query("select * from (select distinct DATE(created_at, 'unixepoch') as date from measurement order by date desc limit :count) sub join measurement m on sub.date = DATE(m.created_at, 'unixepoch') WHERE parent_gabarit_tor_uid=:uidDimensionFence")
    fun getCountLastMeasurementsOfDimensionsFence(uidDimensionFence: String, count: Int): List<Measurement>

    @Query("SELECT * FROM measurement WHERE parent_most_perehod_uid=:uidBridge")
    fun getMeasurementsOfBridge(uidBridge: String): List<Measurement>

    @Query("SELECT * FROM measurement WHERE uid=:uid")
    fun getMeasurementById(uid: String): Measurement

    @Query("SELECT * FROM measurement WHERE parent_gabarit_tor_uid=:uidDimension")
    fun getMeasurementOfDimensionsFence(uidDimension: String): Measurement?

    @Query("SELECT * FROM measurement WHERE parent_gabarit_naves_uid=:uid")
    fun getMeasurementsOfCanopy(uid: String): List<Measurement>

    @Query("SELECT * FROM measurement WHERE type_measurement_uid=:uidType AND parent_contact_wire_uid=:uid")
    fun getMeasurementsOfContactWire(uid: String, uidType: String): Measurement?

    @Query("SELECT * FROM measurement WHERE type_measurement_uid=:uidType AND parent_main_wire_uid=:uid")
    fun getMeasurementsOfCarrierWire(uid: String, uidType: String): Measurement?

    @Query("UPDATE measurement SET vertical_gabarit = :v,horizontal_gabarit = :h ,flag_edited = :flag_edited  WHERE uid =:uid")
    fun updateMeasurementOfCanopy(uid: String, v: String, h: String, flag_edited: Boolean = true)

    @Query("UPDATE measurement SET vertical_gabarit = :v,horizontal_gabarit = :h,flag_edited = :flag_edited  WHERE parent_gabarit_tor_uid =:uid")
    fun updateMeasurementOfDimension(uid: String, v: String, h: String, flag_edited: Boolean=true)

    @Query("SELECT * FROM measurement WHERE flag_created=:flag_created")
    fun getMeasurementsCreated(flag_created: Boolean = true): List<Measurement>

    @Query("SELECT * FROM measurement WHERE flag_edited=:flag_edited and flag_created is null")
    fun getMeasurementsEdited(
        flag_edited: Boolean = true
    ): List<Measurement>

    @Transaction
    fun updateMeasurementOfCanopy(
        uid1: String, v1: String, h1: String,
        uid2: String, v2: String, h2: String,
        uid3: String, v3: String, h3: String
    ) {
        updateMeasurementOfCanopy(uid1, v1, h1)
        updateMeasurementOfCanopy(uid2, v2, h2)
        updateMeasurementOfCanopy(uid3, v3, h3)
    }

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    //@Insert()
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(measurement: Measurement)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(measurements: List<Measurement>)
}