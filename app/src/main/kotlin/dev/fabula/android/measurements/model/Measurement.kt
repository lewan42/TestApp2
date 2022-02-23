package dev.fabula.android.measurements.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "measurement")
data class Measurement(
    @PrimaryKey(autoGenerate = false)
    val uid: String,
    @SerializedName("value")
    val gipotinuza: String,
    val ugol_naklona: String,
    val vertical_gabarit: String,
    val horizontal_gabarit: String,
    val lat: String?,
    @SerializedName("long")
    val lng: String?,
    val km_way: Int,
    val way_number: Int,
    val picket: Int,
    val radius: Int = 0,
    val vozvishenie: Int = 0,
    val comment: String?,
    var photo1: String?,
    var photo2: String?,
    val parent_platform_uid: String?,
    val parent_gabarit_naves_uid: String?,
    val parent_gabarit_tor_uid: String?,
    val parent_main_wire_uid: String?,
    val parent_contact_wire_uid: String?,
    val parent_most_perehod_uid: String?,
    val type_measurement_uid: String?,
    val flag_created: Boolean?,
    val flag_edited: Boolean?,
    val created_at: Long
)


data class MeasurementRequest(
    val uid: String,
    val value: String,
    val ugol_naklona: String,
    val vertical_gabarit: String?,
    val horizontal_gabarit: String?,
    val km_way: Double?,
    val way_number: String?,
    val picket: String?,
    val radius: Int = 0,
    val vozvishenie: Int = 0,
    val comment: String?,
    val photo1: String?,
    val photo2: String?,
    val parent_platform_uid: String?,
    val parent_gabarit_naves_uid: String?,
    val parent_gabarit_tor_uid: String?,
    val parent_main_wire_uid: String?,
    val parent_contact_wire_uid: String?,
    val parent_most_perehod_uid: String?,
    val type_measurement_uid: String?,
    val created_at: Long
)

data class MeasurementWrite(
    val opora: String?,
    val platform: String?,
    val naves: String?,
    val torcevoe_ograzdenie: String?,
    val main_wire: String?,
    val contact_wire: String?,
    val bridge: String?,
    val user: String,
    val type: String,
    val note: List<NoteForMeasurementWriteSerializerForMeasurement>?,
    val attachment: List<AttachmentForMeasurementWriteSerializerForMeasurement>?,
    val value: Double,
    val date: String,
    val geolocation: GeoLocationWrite
)

data class GeoLocationWrite(
    val point: PointWrite,
    val polygon: PolygonWrite?,
    val geo_addition: GeoAdditionWrite
)

data class PointWrite(
    val lat: Double,
    val long: Double
)

data class PolygonWrite(
    val polygon: String = ""
)

data class GeoAdditionWrite(
    val picket: Int,
    val km: Double,
    val path: Int
)

data class AttachmentForMeasurementWriteSerializerForMeasurement(
    val attachment: AttachmentWrite
)

data class NoteForMeasurementWriteSerializerForMeasurement(
    val note: NoteWrite
)

data class NoteWrite(
    val title: String = "Заголовок",
    val subject: String?,
    val content: String?,
    val attachment: List<AttachmentForNoteWriteSerializerForNote>,
    val type: String?
)

data class AttachmentForNoteWriteSerializerForNote(
    val attachment: AttachmentWrite
)

data class AttachmentWrite(
    val name: String = "Название фото",
    val type: String?,
    val upload_file: String
)

data class MeasurementResponse(
    val results: List<Measurement>
)

data class MeasureCalibration(
    var L1: Double,
    var a1: Double,
    var L0: Double,
    var dh: Double
)

data class MeasureCalc(
    var length: String,
    var height: String,
    var L2: Double,
    var a2: Double,
    var ugol: String,
    var gipotinuza: String,
    var info: String,
    var isMeasureOverNormal: Boolean,
    var whichDirection: String?
)

data class BoschMeasurement(
    var result: Double,
    var devMode: Double,
    var gipotinuza: Double,
    var ugol: Double
)

class LittleMeasurement(
    var L: Double,
    var Hvn: Double,
    var Hmin: Double,
    var info: String
)