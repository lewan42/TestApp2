package dev.fabula.android.measurements.type.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "type_measurement")
data class MeasurementType(
    @PrimaryKey(autoGenerate = false)
    val uid: String,
    val name: String,
    val norma: Double,
    val allowableErrorPlus: Double,
    val allowableErrorMinus: Double,
    val type_of: String,
)