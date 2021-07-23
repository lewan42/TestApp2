package dev.fabula.android.station.peregon.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.fabula.android.platform.model.Platform

@Entity(tableName = "station_peregon")
data class StationPeregon(
    @PrimaryKey(autoGenerate = false)
    val uid: String,
    val name: String,
    val railway_sector_uid: String,
    val type_of: String,
    val platform_count: Int,
    val most_bridge_count: Int,
    val opora_count: Int,
    val comment: String?,
    val photo1: String?,
    val photo2: String?,
    val flag_edited: Boolean?
)

data class StationRequest(
    val photo1: String?,
    val photo2: String?,
    val comment: String?
)

class StationResponse(
    val results: List<StationPeregon>
)
