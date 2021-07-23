package dev.fabula.android.platform.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "platform")
data class Platform(
    @PrimaryKey(autoGenerate = false)
    val uid: String,
    val number: String,
    val station_uid: String,
    val owner: String,
    val way_number: String,
    val km_way: String,
    val picket: String,
    val type1: String,
    val type2: String,
    val comment: String?,
    val photo1: String?,
    val photo2: String?,
    val type_gabarits_uid: String?,
    val type_platform_uid: String?,
    val flag_edited: Boolean?
)

class PlatformRequest(
    val uid: String,
    val number: String,
    val way_number: String,
    val km_way: String,
    val picket: String,
    val type1: String,
    val type2: String,
    val comment: String?,
    val photo1: String?,
    val photo2: String?,
    val type_gabarits_uid: String?,
    val type_platform_uid: String?,
)

class PlatformResponse(
    val results: List<Platform>
)

