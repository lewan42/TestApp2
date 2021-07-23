package dev.fabula.android.bosch.otg.model

import android.graphics.Bitmap

data class BoschOtgItemList(
    val date: String,
    val function: String,
    val operation: String?,
    val reference: String?,
    val measurement: String,
    val unit: String?,
    val value1: String,
    val unit1: String?,
    val value2: String?,
    val unit2: String?,
    val value3: String,
    val unit3: String?,
    val noImage: String?,
    val bitmap: Bitmap?
)