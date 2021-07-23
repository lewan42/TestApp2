package dev.fabula.android.station.peregon.dao

import androidx.room.*
import dev.fabula.android.platform.model.Platform
import dev.fabula.android.station.peregon.model.StationPeregon
import dev.fabula.android.support.model.Support
import kotlinx.coroutines.flow.Flow

@Dao
interface StationPeregonDao {

    @Query("DELETE FROM station_peregon")
    fun deleteAll()

    @Query("DELETE FROM station_peregon WHERE uid = :uid")
    fun deleteById(uid: String)

    @Query("UPDATE station_peregon SET flag_edited = :flag WHERE uid =:uid")
    fun updateFlagEdited(uid: String, flag: Boolean)

    @Query("SELECT * FROM station_peregon")
    fun getStationPeregons(): Flow<List<StationPeregon>>

    @Query("SELECT * FROM station_peregon WHERE flag_edited=:flag")
    fun getEditedStations(flag: Boolean = true): List<StationPeregon>

    @Query("SELECT * FROM station_peregon WHERE uid=:id")
    fun getStationPeregonsById(id: String): StationPeregon

    @Query("SELECT * FROM station_peregon WHERE railway_sector_uid=:idRailwaySection and name LIKE '%' || :query || '%'")
    fun getStationPeregonsByIdAndQuery(
        idRailwaySection: String,
        query: String
    ): List<StationPeregon>

    @Query("SELECT * FROM station_peregon WHERE railway_sector_uid=:idRailwaySection and type_of=:type")
    fun getListStationOrPeregonByIdAndType(
        idRailwaySection: String,
        type: String?
    ): List<StationPeregon>

    @Query("SELECT * FROM station_peregon WHERE railway_sector_uid=:idRailwaySection and type_of=:type and name LIKE '%' || :query || '%'")
    fun getListStationOrPeregonByIdAndTypeAndQuery(
        idRailwaySection: String,
        type: String,
        query: String
    ): List<StationPeregon>

    @Insert()
    fun insert(stationPeregon: StationPeregon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(stationPeregon: StationPeregon)

    @Query("UPDATE station_peregon SET comment = :comment, photo1 = :photo1, photo2 = :photo2, flag_edited=:flag_edited  WHERE uid =:uidStation")
    fun update(
        uidStation: String,
        comment: String,
        photo1: String?,
        photo2: String?,
        flag_edited: Boolean = true
    )
}