package dev.fabula.android.canopy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "canopy")
data class Canopy(
    @PrimaryKey(autoGenerate = false)
    val uid: String,
    val platform_uid: String,
    val north_uid: String?,
    val south_uid: String?,
    val center_uid: String?,
    val flag_created: Boolean?,
    val flag_edited: Boolean?
)

data class CanopyRequest(
    val uid: String,
    val platform_uid: String,
    val north_uid: String?,
    val south_uid: String?,
    val center_uid: String?
)

data class CanopyResponse(
    val results: List<Canopy>
)