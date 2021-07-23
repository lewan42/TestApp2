package dev.fabula.android.canopy.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJa\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Ldev/fabula/android/canopy/repo/CanopyRepository;", "", "canopyDao", "Ldev/fabula/android/canopy/dao/CanopyDao;", "createMeasurementsDao", "Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;", "(Ldev/fabula/android/canopy/dao/CanopyDao;Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;)V", "getCanopyById", "Ldev/fabula/android/canopy/model/Canopy;", "uidPlatform", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMeasurementsOfCanopy", "", "Ldev/fabula/android/measurements/model/Measurement;", "uidCanopy", "updateMeasurementOfCanopy", "", "uid1", "v1", "h1", "uid2", "v2", "h2", "uid3", "v3", "h3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class CanopyRepository {
    private final dev.fabula.android.canopy.dao.CanopyDao canopyDao = null;
    private final dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementsDao = null;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getCanopyById(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.canopy.model.Canopy> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getMeasurementsOfCanopy(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<dev.fabula.android.measurements.model.Measurement>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object updateMeasurementOfCanopy(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy, @org.jetbrains.annotations.NotNull()
    java.lang.String uid1, @org.jetbrains.annotations.NotNull()
    java.lang.String v1, @org.jetbrains.annotations.NotNull()
    java.lang.String h1, @org.jetbrains.annotations.NotNull()
    java.lang.String uid2, @org.jetbrains.annotations.NotNull()
    java.lang.String v2, @org.jetbrains.annotations.NotNull()
    java.lang.String h2, @org.jetbrains.annotations.NotNull()
    java.lang.String uid3, @org.jetbrains.annotations.NotNull()
    java.lang.String v3, @org.jetbrains.annotations.NotNull()
    java.lang.String h3, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p10) {
        return null;
    }
    
    @javax.inject.Inject()
    public CanopyRepository(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.canopy.dao.CanopyDao canopyDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementsDao) {
        super();
    }
}