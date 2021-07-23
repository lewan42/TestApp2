package dev.fabula.android.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao
import dev.fabula.android.bridge.crossing.model.BridgeCrossing
import dev.fabula.android.canopy.dao.CanopyDao
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao
import dev.fabula.android.measurements.type.model.MeasurementType
import dev.fabula.android.platform.dao.PlatformDao
import dev.fabula.android.platform.model.Platform
import dev.fabula.android.railway.dao.RailwayDao
import dev.fabula.android.railway.model.Railway
import dev.fabula.android.report.dao.ReportDao
import dev.fabula.android.section.dao.RailwaySectionDao
import dev.fabula.android.section.model.RailwaySection
import dev.fabula.android.station.peregon.dao.StationPeregonDao
import dev.fabula.android.station.peregon.model.StationPeregon
import dev.fabula.android.support.dao.SupportDao
import dev.fabula.android.support.model.Support
import dev.fabula.android.wire.carrier.dao.CarrierWireDao
import dev.fabula.android.wire.carrier.di.CarrierWireDaoModule
import dev.fabula.android.wire.carrier.model.CarrierWire
import dev.fabula.android.wire.contact.dao.ContactWireDao
import dev.fabula.android.wire.contact.model.ContactWire

@Database(
    entities = [
        Railway::class,
        RailwaySection::class,
        StationPeregon::class,
        Support::class,
        Platform::class,
        BridgeCrossing::class,
        Measurement::class,
        DimensionsFence::class,
        Canopy::class,
        ContactWire::class,
        CarrierWire::class,
        MeasurementType::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun railwayDao(): RailwayDao
    abstract fun railwaySectionDao(): RailwaySectionDao
    abstract fun reportDao(): ReportDao
    abstract fun stationPeregonDao(): StationPeregonDao
    abstract fun supportDao(): SupportDao
    abstract fun platformDao(): PlatformDao
    abstract fun bridgeCrossingDao(): BridgeCrossingDao
    abstract fun createMeasurementDao(): CreateMeasurementsDao
    abstract fun dimensionsFenceDao(): DimensionsFenceDao
    abstract fun canopyDao(): CanopyDao
    abstract fun contactWireDao(): ContactWireDao
    abstract fun carrierWireDao(): CarrierWireDao
    abstract fun measurementTypeDao(): MeasurementTypeDao
}