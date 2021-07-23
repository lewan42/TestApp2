package dev.fabula.android.wire.contact.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "contact_wire")
data class ContactWire(
    @PrimaryKey(autoGenerate = false)
    val uid: String,
    val opora_uid: String,
    @SerializedName("type_contact_wire_uid")
    val type_height_wire_uid: String,
    val type_zigzag_wire_uid: String,
    val flag_created: Boolean?
)


data class ContactWireRequest(
    val uid: String,
    val opora_uid: String,
    val type_contact_wire_uid: String,
    val type_zigzag_wire_uid: String
)

data class ContactWireResponse(
    val results: List<ContactWire>
)