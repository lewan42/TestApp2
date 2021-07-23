package dev.fabula.android.support.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017JW\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u00162\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0019\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010\u0015\u001a\u00020\u0016J\u0019\u0010)\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J#\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J#\u00100\u001a\u0004\u0018\u00010,2\u0006\u00101\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J\u0019\u00102\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0019\u00103\u001a\u0002042\u0006\u0010\u0015\u001a\u00020\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017JW\u00105\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\b\u00106\u001a\u0004\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u00162\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2 = {"Ldev/fabula/android/support/repo/SupportRepository;", "", "supportDao", "Ldev/fabula/android/support/dao/SupportDao;", "supportApi", "Ldev/fabula/android/support/api/SupportApi;", "platformDao", "Ldev/fabula/android/platform/dao/PlatformDao;", "bridgeDao", "Ldev/fabula/android/bridge/crossing/dao/BridgeCrossingDao;", "contactWireDao", "Ldev/fabula/android/wire/contact/dao/ContactWireDao;", "carrierWireDao", "Ldev/fabula/android/wire/carrier/dao/CarrierWireDao;", "measurementTypeDao", "Ldev/fabula/android/measurements/type/dao/MeasurementTypeDao;", "createMeasurementsDao", "Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;", "(Ldev/fabula/android/support/dao/SupportDao;Ldev/fabula/android/support/api/SupportApi;Ldev/fabula/android/platform/dao/PlatformDao;Ldev/fabula/android/bridge/crossing/dao/BridgeCrossingDao;Ldev/fabula/android/wire/contact/dao/ContactWireDao;Ldev/fabula/android/wire/carrier/dao/CarrierWireDao;Ldev/fabula/android/measurements/type/dao/MeasurementTypeDao;Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;)V", "countWiresOfSupport", "", "uidSupport", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSupport", "uidPlatform", "contentType", "number", "kmWay", "wayNumber", "picket", "photo1", "photo2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBridgeName", "uidBridge", "getCarrierWireBySupport", "Ldev/fabula/android/wire/carrier/model/CarrierWire;", "getCarrierWireForBySupport", "getContactWireForBySupport", "Ldev/fabula/android/wire/contact/model/ContactWire;", "getCountContactWireOfSupport", "", "getMeasurementByParentCarrierWire", "Ldev/fabula/android/measurements/model/Measurement;", "uidCarrierWire", "uidTypeMeasurement", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMeasurementByParentContactWire", "uidContactWire", "getPlatformName", "getSupportById", "Ldev/fabula/android/support/model/Support;", "supportUpdate", "comment", "app_release"})
public final class SupportRepository {
    private final dev.fabula.android.support.dao.SupportDao supportDao = null;
    private final dev.fabula.android.support.api.SupportApi supportApi = null;
    private final dev.fabula.android.platform.dao.PlatformDao platformDao = null;
    private final dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao bridgeDao = null;
    private final dev.fabula.android.wire.contact.dao.ContactWireDao contactWireDao = null;
    private final dev.fabula.android.wire.carrier.dao.CarrierWireDao carrierWireDao = null;
    private final dev.fabula.android.measurements.type.dao.MeasurementTypeDao measurementTypeDao = null;
    private final dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementsDao = null;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object supportUpdate(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport, @org.jetbrains.annotations.NotNull()
    java.lang.String number, @org.jetbrains.annotations.NotNull()
    java.lang.String kmWay, @org.jetbrains.annotations.NotNull()
    java.lang.String wayNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String picket, @org.jetbrains.annotations.Nullable()
    java.lang.String comment, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p8) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object createSupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, @org.jetbrains.annotations.NotNull()
    java.lang.String contentType, @org.jetbrains.annotations.NotNull()
    java.lang.String number, @org.jetbrains.annotations.NotNull()
    java.lang.String kmWay, @org.jetbrains.annotations.NotNull()
    java.lang.String wayNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String picket, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> p8) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object countWiresOfSupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getCarrierWireBySupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.wire.carrier.model.CarrierWire> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final dev.fabula.android.wire.contact.model.ContactWire getContactWireForBySupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final dev.fabula.android.wire.carrier.model.CarrierWire getCarrierWireForBySupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getMeasurementByParentContactWire(@org.jetbrains.annotations.NotNull()
    java.lang.String uidContactWire, @org.jetbrains.annotations.NotNull()
    java.lang.String uidTypeMeasurement, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.measurements.model.Measurement> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getMeasurementByParentCarrierWire(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCarrierWire, @org.jetbrains.annotations.NotNull()
    java.lang.String uidTypeMeasurement, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.measurements.model.Measurement> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getSupportById(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.support.model.Support> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getCountContactWireOfSupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getPlatformName(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getBridgeName(@org.jetbrains.annotations.NotNull()
    java.lang.String uidBridge, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> p1) {
        return null;
    }
    
    @javax.inject.Inject()
    public SupportRepository(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.support.dao.SupportDao supportDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.support.api.SupportApi supportApi, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.platform.dao.PlatformDao platformDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao bridgeDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.wire.contact.dao.ContactWireDao contactWireDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.wire.carrier.dao.CarrierWireDao carrierWireDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.type.dao.MeasurementTypeDao measurementTypeDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementsDao) {
        super();
    }
}