package dev.fabula.android.synchronize.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u00bf\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020\'\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020+\u0012\u0006\u0010,\u001a\u00020-\u0012\u0006\u0010.\u001a\u00020/\u00a2\u0006\u0002\u00100J\u0016\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0002J\u0016\u00106\u001a\u0002022\f\u00107\u001a\b\u0012\u0004\u0012\u00020804H\u0002J\u0016\u00109\u001a\u0002022\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;04H\u0002J\u0016\u0010<\u001a\u0002022\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>04H\u0002J\u0016\u0010?\u001a\u0002022\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A04H\u0002J\u0016\u0010B\u001a\u0002022\f\u0010C\u001a\b\u0012\u0004\u0012\u00020D04H\u0002J\u0016\u0010E\u001a\u0002022\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G04H\u0002J\u0016\u0010H\u001a\u0002022\f\u0010I\u001a\b\u0012\u0004\u0012\u00020J04H\u0002J\u0016\u0010K\u001a\u0002022\f\u0010L\u001a\b\u0012\u0004\u0012\u00020M04H\u0002J\u0016\u0010N\u001a\u0002022\f\u0010O\u001a\b\u0012\u0004\u0012\u00020P04H\u0002J\u0016\u0010Q\u001a\u0002022\f\u0010R\u001a\b\u0012\u0004\u0012\u00020S04H\u0002J\u0016\u0010T\u001a\u0002022\f\u0010U\u001a\b\u0012\u0004\u0012\u00020V04H\u0002J\u0011\u0010W\u001a\u00020XH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010YJ\u0010\u0010Z\u001a\u0002022\u0006\u0010[\u001a\u00020\\H\u0002J\u0011\u0010]\u001a\u00020XH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010YJ\u0011\u0010^\u001a\u00020XH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010YJ-\u0010_\u001a\u0002022\f\u0010`\u001a\b\u0012\u0004\u0012\u000205042\f\u0010a\u001a\b\u0012\u0004\u0012\u00020504H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010bJ-\u0010c\u001a\u0002022\f\u0010d\u001a\b\u0012\u0004\u0012\u000208042\f\u0010e\u001a\b\u0012\u0004\u0012\u00020804H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010bJ\u001f\u0010f\u001a\u0002022\f\u0010g\u001a\b\u0012\u0004\u0012\u00020;04H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010hJ\u001f\u0010i\u001a\u0002022\f\u0010j\u001a\b\u0012\u0004\u0012\u00020>04H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010hJ-\u0010k\u001a\u0002022\f\u0010l\u001a\b\u0012\u0004\u0012\u00020A042\f\u0010m\u001a\b\u0012\u0004\u0012\u00020A04H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010bJ-\u0010n\u001a\u0002022\f\u0010o\u001a\b\u0012\u0004\u0012\u00020G042\f\u0010p\u001a\b\u0012\u0004\u0012\u00020G04H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010bJ\u001f\u0010q\u001a\u0002022\f\u0010r\u001a\b\u0012\u0004\u0012\u00020J04H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010hJ\u001f\u0010s\u001a\u0002022\f\u0010t\u001a\b\u0012\u0004\u0012\u00020S04H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010hJ-\u0010u\u001a\u0002022\f\u0010v\u001a\b\u0012\u0004\u0012\u00020V042\f\u0010w\u001a\b\u0012\u0004\u0012\u00020V04H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010bJ\u0011\u0010x\u001a\u00020XH\u0083@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010YR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006y"}, d2 = {"Ldev/fabula/android/synchronize/repo/SyncRepository;", "", "auth", "Ldev/fabula/android/auth_old/AppAuth;", "syncApi", "Ldev/fabula/android/synchronize/api/SyncApi;", "railwayDao", "Ldev/fabula/android/railway/dao/RailwayDao;", "railwaySectionDao", "Ldev/fabula/android/section/dao/RailwaySectionDao;", "stationPeregonDao", "Ldev/fabula/android/station/peregon/dao/StationPeregonDao;", "platformDao", "Ldev/fabula/android/platform/dao/PlatformDao;", "supportDao", "Ldev/fabula/android/support/dao/SupportDao;", "createMeasurementsDao", "Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;", "bridgeCrossingDao", "Ldev/fabula/android/bridge/crossing/dao/BridgeCrossingDao;", "dimensionsFenceDao", "Ldev/fabula/android/dimensions/fence/dao/DimensionsFenceDao;", "canopyDao", "Ldev/fabula/android/canopy/dao/CanopyDao;", "contactWireDao", "Ldev/fabula/android/wire/contact/dao/ContactWireDao;", "carrierWireDao", "Ldev/fabula/android/wire/carrier/dao/CarrierWireDao;", "stationApi", "Ldev/fabula/android/station/peregon/api/StationApi;", "platformApi", "Ldev/fabula/android/platform/api/PlatformApi;", "createMeasurementsApi", "Ldev/fabula/android/measurements/create/api/CreateMeasurementsApi;", "dimensionFenceAPI", "Ldev/fabula/android/dimensions/fence/api/DimensionFenceAPI;", "contactWireApi", "Ldev/fabula/android/wire/contact/api/ContactWireApi;", "carrierWireApi", "Ldev/fabula/android/wire/carrier/api/CarrierWireApi;", "measurementTypeDao", "Ldev/fabula/android/measurements/type/dao/MeasurementTypeDao;", "canopyApi", "Ldev/fabula/android/canopy/api/CanopyApi;", "supportApi", "Ldev/fabula/android/support/api/SupportApi;", "bridgeApi", "Ldev/fabula/android/bridge/crossing/api/BridgeApi;", "(Ldev/fabula/android/auth_old/AppAuth;Ldev/fabula/android/synchronize/api/SyncApi;Ldev/fabula/android/railway/dao/RailwayDao;Ldev/fabula/android/section/dao/RailwaySectionDao;Ldev/fabula/android/station/peregon/dao/StationPeregonDao;Ldev/fabula/android/platform/dao/PlatformDao;Ldev/fabula/android/support/dao/SupportDao;Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;Ldev/fabula/android/bridge/crossing/dao/BridgeCrossingDao;Ldev/fabula/android/dimensions/fence/dao/DimensionsFenceDao;Ldev/fabula/android/canopy/dao/CanopyDao;Ldev/fabula/android/wire/contact/dao/ContactWireDao;Ldev/fabula/android/wire/carrier/dao/CarrierWireDao;Ldev/fabula/android/station/peregon/api/StationApi;Ldev/fabula/android/platform/api/PlatformApi;Ldev/fabula/android/measurements/create/api/CreateMeasurementsApi;Ldev/fabula/android/dimensions/fence/api/DimensionFenceAPI;Ldev/fabula/android/wire/contact/api/ContactWireApi;Ldev/fabula/android/wire/carrier/api/CarrierWireApi;Ldev/fabula/android/measurements/type/dao/MeasurementTypeDao;Ldev/fabula/android/canopy/api/CanopyApi;Ldev/fabula/android/support/api/SupportApi;Ldev/fabula/android/bridge/crossing/api/BridgeApi;)V", "insertBridges", "", "bridgeList", "", "Ldev/fabula/android/bridge/crossing/model/BridgeCrossing;", "insertCanopy", "canopiesList", "Ldev/fabula/android/canopy/model/Canopy;", "insertCarrierWire", "carrierWireList", "Ldev/fabula/android/wire/carrier/model/CarrierWire;", "insertContactWire", "contactWireList", "Ldev/fabula/android/wire/contact/model/ContactWire;", "insertDimensionsFence", "dimensionsList", "Ldev/fabula/android/dimensions/fence/model/DimensionsFence;", "insertMeasurementType", "measurementTypeList", "Ldev/fabula/android/measurements/type/model/MeasurementType;", "insertMeasurements", "measurementList", "Ldev/fabula/android/measurements/model/Measurement;", "insertPlatforms", "platformList", "Ldev/fabula/android/platform/model/Platform;", "insertRailwaySections", "railwaySectionList", "Ldev/fabula/android/section/model/RailwaySection;", "insertRailways", "railwayList", "Ldev/fabula/android/railway/model/Railway;", "insertStations", "stationList", "Ldev/fabula/android/station/peregon/model/StationPeregon;", "insertSupports", "supportList", "Ldev/fabula/android/support/model/Support;", "isNotSyncData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseResponse", "response", "Ldev/fabula/android/synchronize/model/SyncResponse;", "removeAll", "sync", "syncBridges", "listBridgeCreate", "listBridgeEdited", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncCanopies", "listCanopiesCreated", "listCanopiesEdited", "syncCarrierWire", "listCarrierWire", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncContactWire", "listContactWire", "syncDimensionFence", "listDimensionsFenceCreate", "listDimensionsFenceUpdate", "syncMeasurement", "listMeasurementCreate", "listMeasurementUpdate", "syncPlatform", "listPlatforms", "syncStation", "listStation", "syncSupport", "listSupportCreate", "listSupportEdited", "upload", "app_release"})
public final class SyncRepository {
    private final dev.fabula.android.auth_old.AppAuth auth = null;
    private final dev.fabula.android.synchronize.api.SyncApi syncApi = null;
    private final dev.fabula.android.railway.dao.RailwayDao railwayDao = null;
    private final dev.fabula.android.section.dao.RailwaySectionDao railwaySectionDao = null;
    private final dev.fabula.android.station.peregon.dao.StationPeregonDao stationPeregonDao = null;
    private final dev.fabula.android.platform.dao.PlatformDao platformDao = null;
    private final dev.fabula.android.support.dao.SupportDao supportDao = null;
    private final dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementsDao = null;
    private final dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao bridgeCrossingDao = null;
    private final dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao dimensionsFenceDao = null;
    private final dev.fabula.android.canopy.dao.CanopyDao canopyDao = null;
    private final dev.fabula.android.wire.contact.dao.ContactWireDao contactWireDao = null;
    private final dev.fabula.android.wire.carrier.dao.CarrierWireDao carrierWireDao = null;
    private final dev.fabula.android.station.peregon.api.StationApi stationApi = null;
    private final dev.fabula.android.platform.api.PlatformApi platformApi = null;
    private final dev.fabula.android.measurements.create.api.CreateMeasurementsApi createMeasurementsApi = null;
    private final dev.fabula.android.dimensions.fence.api.DimensionFenceAPI dimensionFenceAPI = null;
    private final dev.fabula.android.wire.contact.api.ContactWireApi contactWireApi = null;
    private final dev.fabula.android.wire.carrier.api.CarrierWireApi carrierWireApi = null;
    private final dev.fabula.android.measurements.type.dao.MeasurementTypeDao measurementTypeDao = null;
    private final dev.fabula.android.canopy.api.CanopyApi canopyApi = null;
    private final dev.fabula.android.support.api.SupportApi supportApi = null;
    private final dev.fabula.android.bridge.crossing.api.BridgeApi bridgeApi = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isNotSyncData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p0) {
        return null;
    }
    
    private final void parseResponse(dev.fabula.android.synchronize.model.SyncResponse response) {
    }
    
    private final void insertRailways(java.util.List<dev.fabula.android.railway.model.Railway> railwayList) {
    }
    
    private final void insertRailwaySections(java.util.List<dev.fabula.android.section.model.RailwaySection> railwaySectionList) {
    }
    
    private final void insertStations(java.util.List<dev.fabula.android.station.peregon.model.StationPeregon> stationList) {
    }
    
    private final void insertSupports(java.util.List<dev.fabula.android.support.model.Support> supportList) {
    }
    
    private final void insertPlatforms(java.util.List<dev.fabula.android.platform.model.Platform> platformList) {
    }
    
    private final void insertMeasurements(java.util.List<dev.fabula.android.measurements.model.Measurement> measurementList) {
    }
    
    private final void insertBridges(java.util.List<dev.fabula.android.bridge.crossing.model.BridgeCrossing> bridgeList) {
    }
    
    private final void insertDimensionsFence(java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsFence> dimensionsList) {
    }
    
    private final void insertCanopy(java.util.List<dev.fabula.android.canopy.model.Canopy> canopiesList) {
    }
    
    private final void insertContactWire(java.util.List<dev.fabula.android.wire.contact.model.ContactWire> contactWireList) {
    }
    
    private final void insertCarrierWire(java.util.List<dev.fabula.android.wire.carrier.model.CarrierWire> carrierWireList) {
    }
    
    private final void insertMeasurementType(java.util.List<dev.fabula.android.measurements.type.model.MeasurementType> measurementTypeList) {
    }
    
    @javax.inject.Inject()
    public SyncRepository(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.auth_old.AppAuth auth, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.synchronize.api.SyncApi syncApi, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.railway.dao.RailwayDao railwayDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.section.dao.RailwaySectionDao railwaySectionDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.station.peregon.dao.StationPeregonDao stationPeregonDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.platform.dao.PlatformDao platformDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.support.dao.SupportDao supportDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementsDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao bridgeCrossingDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao dimensionsFenceDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.canopy.dao.CanopyDao canopyDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.wire.contact.dao.ContactWireDao contactWireDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.wire.carrier.dao.CarrierWireDao carrierWireDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.station.peregon.api.StationApi stationApi, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.platform.api.PlatformApi platformApi, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.create.api.CreateMeasurementsApi createMeasurementsApi, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.dimensions.fence.api.DimensionFenceAPI dimensionFenceAPI, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.wire.contact.api.ContactWireApi contactWireApi, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.wire.carrier.api.CarrierWireApi carrierWireApi, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.type.dao.MeasurementTypeDao measurementTypeDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.canopy.api.CanopyApi canopyApi, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.support.api.SupportApi supportApi, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.bridge.crossing.api.BridgeApi bridgeApi) {
        super();
    }
}