package dev.fabula.android.measurements.create.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J!\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J!\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ!\u0010 \u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Ldev/fabula/android/measurements/create/repo/CreateMeasurementsRepository;", "", "createMeasurementsDao", "Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;", "canopyDao", "Ldev/fabula/android/canopy/dao/CanopyDao;", "dimensionsFenceDao", "Ldev/fabula/android/dimensions/fence/dao/DimensionsFenceDao;", "(Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;Ldev/fabula/android/canopy/dao/CanopyDao;Ldev/fabula/android/dimensions/fence/dao/DimensionsFenceDao;)V", "getMeasurementById", "Ldev/fabula/android/measurements/model/Measurement;", "uid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "measurement", "(Ldev/fabula/android/measurements/model/Measurement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "measurements", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertDimensionAndMeasurement", "dimensionsFence", "Ldev/fabula/android/dimensions/fence/model/DimensionsFence;", "(Ldev/fabula/android/measurements/model/Measurement;Ldev/fabula/android/dimensions/fence/model/DimensionsFence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "updateCanopyCenter", "uidCanopy", "uidMeasurement", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCanopyNorth", "updateCanopySouth", "app_release"})
public final class CreateMeasurementsRepository {
    private final dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementsDao = null;
    private final dev.fabula.android.canopy.dao.CanopyDao canopyDao = null;
    private final dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao dimensionsFenceDao = null;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getMeasurementById(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.measurements.model.Measurement> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.measurements.model.Measurement> measurements, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.model.Measurement measurement, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insertDimensionAndMeasurement(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.model.Measurement measurement, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.dimensions.fence.model.DimensionsFence dimensionsFence, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object update(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.model.Measurement measurement, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object updateCanopyNorth(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy, @org.jetbrains.annotations.NotNull()
    java.lang.String uidMeasurement, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object updateCanopyCenter(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy, @org.jetbrains.annotations.NotNull()
    java.lang.String uidMeasurement, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object updateCanopySouth(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy, @org.jetbrains.annotations.NotNull()
    java.lang.String uidMeasurement, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p2) {
        return null;
    }
    
    @javax.inject.Inject()
    public CreateMeasurementsRepository(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementsDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.canopy.dao.CanopyDao canopyDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao dimensionsFenceDao) {
        super();
    }
}