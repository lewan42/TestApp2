package dev.fabula.android.dimensions.fence.model

data class DimensionsWithMeasure(
    val uid: String,
    val platform_uid: String,
    val direction: String,
    val vertical: String?,
    val horizontal: String?,
    val measurement_uid: String?,
    val measurement_uid_type:String?
)