package dev.fabula.android.app.db;

import java.lang.System;

@androidx.room.Database(entities = {dev.fabula.android.railway.model.Railway.class, dev.fabula.android.section.model.RailwaySection.class, dev.fabula.android.station.peregon.model.StationPeregon.class, dev.fabula.android.support.model.Support.class, dev.fabula.android.platform.model.Platform.class, dev.fabula.android.bridge.crossing.model.BridgeCrossing.class, dev.fabula.android.measurements.model.Measurement.class, dev.fabula.android.dimensions.fence.model.DimensionsFence.class, dev.fabula.android.canopy.model.Canopy.class, dev.fabula.android.wire.contact.model.ContactWire.class, dev.fabula.android.wire.carrier.model.CarrierWire.class, dev.fabula.android.measurements.type.model.MeasurementType.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u001cH&\u00a8\u0006\u001d"}, d2 = {"Ldev/fabula/android/app/db/AppRoomDatabase;", "Landroidx/room/RoomDatabase;", "()V", "bridgeCrossingDao", "Ldev/fabula/android/bridge/crossing/dao/BridgeCrossingDao;", "canopyDao", "Ldev/fabula/android/canopy/dao/CanopyDao;", "carrierWireDao", "Ldev/fabula/android/wire/carrier/dao/CarrierWireDao;", "contactWireDao", "Ldev/fabula/android/wire/contact/dao/ContactWireDao;", "createMeasurementDao", "Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;", "dimensionsFenceDao", "Ldev/fabula/android/dimensions/fence/dao/DimensionsFenceDao;", "measurementTypeDao", "Ldev/fabula/android/measurements/type/dao/MeasurementTypeDao;", "platformDao", "Ldev/fabula/android/platform/dao/PlatformDao;", "railwayDao", "Ldev/fabula/android/railway/dao/RailwayDao;", "railwaySectionDao", "Ldev/fabula/android/section/dao/RailwaySectionDao;", "reportDao", "Ldev/fabula/android/report/dao/ReportDao;", "stationPeregonDao", "Ldev/fabula/android/station/peregon/dao/StationPeregonDao;", "supportDao", "Ldev/fabula/android/support/dao/SupportDao;", "app_release"})
public abstract class AppRoomDatabase extends androidx.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.railway.dao.RailwayDao railwayDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.section.dao.RailwaySectionDao railwaySectionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.report.dao.ReportDao reportDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.station.peregon.dao.StationPeregonDao stationPeregonDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.support.dao.SupportDao supportDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.platform.dao.PlatformDao platformDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao bridgeCrossingDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao dimensionsFenceDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.canopy.dao.CanopyDao canopyDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.wire.contact.dao.ContactWireDao contactWireDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.wire.carrier.dao.CarrierWireDao carrierWireDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract dev.fabula.android.measurements.type.dao.MeasurementTypeDao measurementTypeDao();
    
    public AppRoomDatabase() {
        super();
    }
}