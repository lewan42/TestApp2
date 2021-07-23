package dev.fabula.android.bridge.crossing.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "bridge")
data class BridgeCrossing(
    @PrimaryKey(autoGenerate = false)
    val uid: String,
    val name: String,
    val platform_uid: String,
    val owner: String?,
    val flag_created: Boolean?,
    val flag_edited: Boolean?
) : Parcelable
