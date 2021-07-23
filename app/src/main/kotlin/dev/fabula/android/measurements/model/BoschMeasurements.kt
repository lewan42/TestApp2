package dev.fabula.android.measurements.model

data class BoschMeasurements(
    var length: String,
    var height: String,
    var L2: Double,
    var a2: Double,
    var ugol: String,
    var gipotinuza: String,
    var info: String,
    var isMeasureOverNormal: Boolean
)