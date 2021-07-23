package dev.fabula.android.support.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.fabula.android.canopy.model.Canopy
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "support")
data class Support(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "uid")
    val uid: String,
    @ColumnInfo(name = "content_type")
    val content_type: String,
    @ColumnInfo(name = "parent_uid")
    val parent_uid: String,
    @ColumnInfo(name = "number")
    val number: String,
    @ColumnInfo(name = "km_way")
    val km_way: String?,
    @ColumnInfo(name = "way_number")
    val way_number: String?,
    @ColumnInfo(name = "picket")
    val picket: String?,
    @ColumnInfo(name = "carrier_wire")
    val carrier_wire: String?,
    @ColumnInfo(name = "contact_wire")
    val contact_wire: String?,
    @ColumnInfo(name = "comment")
    val comment: String?,
    @ColumnInfo(name = "photo1")
    val photo1: String?,
    @ColumnInfo(name = "photo2")
    val photo2: String?,
    val flag_created: Boolean?,
    val flag_edited: Boolean?
) : Parcelable

data class SupportResponse(
    val results: List<Support>
)
