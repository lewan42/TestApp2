package dev.fabula.android.report.repo

import dev.fabula.android.measurements.type.dao.MeasurementTypeDao
import dev.fabula.android.measurements.type.model.MeasurementType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReportRepository @Inject constructor(
    private val measurementTypeDao: MeasurementTypeDao
) {
    val typeMeasurements: Flow<List<MeasurementType>> = measurementTypeDao.getTypeMeasurements()
}

