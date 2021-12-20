package dev.fabula.android.dimensions.fence.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.fabula.android.measurements.model.Measurement
import java.io.Serializable

data class DimensionSaveDB(
    val uidD: String,
    val g: String,
    val v: String,
    val dir: String
)

data class DimensionsFenceTransit(
    var listDf: List<DimensionsFence>,
    var parentPlatformUid: String,
    var countDf: Int
) : Serializable

@Entity(tableName = "gabarittor")
data class DimensionsFence(
    @PrimaryKey(autoGenerate = false)
    val uid: String,
    val platform_uid: String,
    var direction: String,
    val flag_created: Boolean?,
    val flag_edited: Boolean?
) : Serializable


data class DimensionsFenceRequest(
    val uid: String,
    val platform_uid: String,
    val direction: String
)

class DimensionsFenceResponse(
    val results: List<DimensionsFence>
)

data class DimensionsWithMeasure(
    val uid: String,
    val platform_uid: String,
    val direction: String,
    val vertical: String?,
    val horizontal: String?,
    val measurement_uid: String?,
    val measurement_uid_type: String?
)

data class DimensionsFenceWithMeasurement(
    var dimensionsFence: DimensionsFence,
    var measurements: Measurement?
)