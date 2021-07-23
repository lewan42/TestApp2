package dev.fabula.android.railway.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "railway")
data class Railway(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "uid")
    var uid: String,
    @ColumnInfo(name = "name")
    val name: String
) : Parcelable