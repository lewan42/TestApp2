package dev.fabula.android.list.items.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItem(
    val id: String,
    val name: String,
) : Parcelable
