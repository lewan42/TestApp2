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
    val km_way: Double?,
    val way_number: String?,
    val picket: String?,
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

data class MeasurementResponse(
    val results: List<Measurement>
)
