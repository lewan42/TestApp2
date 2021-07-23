package dev.fabula.android.measurements.union.list.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Ldev/fabula/android/measurements/union/list/repo/UnionMeasurementsRepository;", "", "createMeasurementsDao", "Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;", "boschOtgDao", "Ldev/fabula/android/bosch/otg/data/source/BoschOtgDataSource;", "(Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;Ldev/fabula/android/bosch/otg/data/source/BoschOtgDataSource;)V", "getCreatedMeasurement", "", "Ldev/fabula/android/measurements/model/Measurement;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDataFromBoschDevice", "Ldev/fabula/android/bosch/otg/model/BoschOtgItemList;", "file", "Ljava/io/File;", "context", "Landroid/content/Context;", "(Ljava/io/File;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePhotoZamer", "", "uid", "", "photo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class UnionMeasurementsRepository {
    private final dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementsDao = null;
    private final dev.fabula.android.bosch.otg.data.source.BoschOtgDataSource boschOtgDao = null;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getCreatedMeasurement(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<dev.fabula.android.measurements.model.Measurement>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getDataFromBoschDevice(@org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<dev.fabula.android.bosch.otg.model.BoschOtgItemList>> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object updatePhotoZamer(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String photo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p2) {
        return null;
    }
    
    @javax.inject.Inject()
    public UnionMeasurementsRepository(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.create.dao.CreateMeasurementsDao createMeasurementsDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.bosch.otg.data.source.BoschOtgDataSource boschOtgDao) {
        super();
    }
}