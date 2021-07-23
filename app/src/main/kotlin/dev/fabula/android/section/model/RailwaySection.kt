package dev.fabula.android.section.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "railway_section")
data class RailwaySection(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "uid")
    val uid: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "railway_uid")
    val railway_uid: String,
) : Parcelable