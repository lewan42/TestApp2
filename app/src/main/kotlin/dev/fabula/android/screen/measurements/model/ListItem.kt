package dev.fabula.android.screen.measurements.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItem(
    val uid: String,
    val uidParent: String,
    val name: String,
    val type: String
) : Parcelable