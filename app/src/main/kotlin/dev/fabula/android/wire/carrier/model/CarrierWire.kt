package dev.fabula.android.wire.carrier.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import dev.fabula.android.dimensions.fence.model.DimensionsFence

@Entity(tableName = "carrier_wire")
data class CarrierWire(
    @PrimaryKey(autoGenerate = false)
    val uid: String,
    val opora_uid: String,
    @SerializedName("type_contact_wire_uid")
    val type_height_wire_uid: String,
    val type_zigzag_wire_uid: String,
    val flag_created: Boolean?
)

data class CarrierWireRequest(
    val uid: String,
    val opora_uid: String,
    val type_contact_wire_uid: String,
    val type_zigzag_wire_uid: String
)

class CarrierWireResponse(
    val results: List<CarrierWire>
)