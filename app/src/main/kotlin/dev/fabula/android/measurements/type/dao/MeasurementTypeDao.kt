package dev.fabula.android.measurements.type.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.fabula.android.measurements.type.model.MeasurementType
import dev.fabula.android.railway.model.Railway
import kotlinx.coroutines.flow.Flow

@Dao
interface MeasurementTypeDao {

    @Query("DELETE FROM type_measurement")
    fun deleteAll()

    @Query("SELECT * FROM type_measurement")
    fun getTypeMeasurements(): Flow<List<MeasurementType>>

    @Query("SELECT * FROM type_measurement WHERE type_of=:type")
    fun getTypeMeasurementByType(type: String): MeasurementType

    @Insert
    fun insert(measurementType: MeasurementType)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(measurementType: MeasurementType)
}