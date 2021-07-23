package dev.fabula.android.dimensions.fence.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0013H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Ldev/fabula/android/dimensions/fence/repo/DimensionsFenceRepository;", "", "platformDao", "Ldev/fabula/android/platform/dao/PlatformDao;", "dimensionsFenceDao", "Ldev/fabula/android/dimensions/fence/dao/DimensionsFenceDao;", "createMeasurementsDao", "Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;", "measurementTypeDao", "Ldev/fabula/android/measurements/type/dao/MeasurementTypeDao;", "(Ldev/fabula/android/platform/dao/PlatformDao;Ldev/fabula/android/dimensions/fence/dao/DimensionsFenceDao;Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;Ldev/fabula/android/measurements/type/dao/MeasurementTypeDao;)V", "autoCreateDimensions", "", "uidPlatform", "", "count", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDimensionList", "", "Ldev/fabula/android/dimensions/fence/model/DimensionsWithMeasure;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlatformById", "Ldev/fabula/android/platform/model/Platform;", "updateDimension", "list", "Ldev/fabula/android/dimensions/fence/model/DimensionSaveDB;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class DimensionsFenceRepository {
    private final dev.fabula.android.platform.dao.PlatformDao platformDao = null;
    private final dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao dimensionsFenceDao = null;
    private final dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementsDao = null;
    private final dev.fabula.android.measurements.type.dao.MeasurementTypeDao measurementTypeDao = null;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getPlatformById(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.platform.model.Platform> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object autoCreateDimensions(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, int count, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object updateDimension(@org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.dimensions.fence.model.DimensionSaveDB> list, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getDimensionList(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsWithMeasure>> p1) {
        return null;
    }
    
    @javax.inject.Inject()
    public DimensionsFenceRepository(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.platform.dao.PlatformDao platformDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao dimensionsFenceDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementsDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.type.dao.MeasurementTypeDao measurementTypeDao) {
        super();
    }
}