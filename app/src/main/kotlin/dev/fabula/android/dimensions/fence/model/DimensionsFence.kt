package dev.fabula.android.dimensions.fence.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.fabula.android.platform.model.Platform

@Entity(tableName = "gabarittor")
data class DimensionsFence(
    @PrimaryKey(autoGenerate = false)
    val uid: String,
    val platform_uid: String,
    val direction: String,
    val flag_created: Boolean?,
    val flag_edited: Boolean?
)

data class DimensionsFenceRequest(
    val uid: String,
    val platform_uid: String,
    val direction: String
)

class DimensionsFenceResponse(
    val results: List<DimensionsFence>
)