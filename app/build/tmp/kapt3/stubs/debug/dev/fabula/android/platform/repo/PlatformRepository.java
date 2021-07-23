package dev.fabula.android.platform.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0016\u001a\u00020\u0012H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013Je\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0018H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Ldev/fabula/android/platform/repo/PlatformRepository;", "", "platformDao", "Ldev/fabula/android/platform/dao/PlatformDao;", "canopyDao", "Ldev/fabula/android/canopy/dao/CanopyDao;", "supportDao", "Ldev/fabula/android/support/dao/SupportDao;", "(Ldev/fabula/android/platform/dao/PlatformDao;Ldev/fabula/android/canopy/dao/CanopyDao;Ldev/fabula/android/support/dao/SupportDao;)V", "allPlatforms", "Lkotlinx/coroutines/flow/Flow;", "", "Ldev/fabula/android/platform/model/Platform;", "getAllPlatforms", "()Lkotlinx/coroutines/flow/Flow;", "getCanopyOfPlatform", "Ldev/fabula/android/canopy/model/Canopy;", "uidPlatform", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlatformById", "getPlatformsOfStationOrPeregon", "uid", "platformUpdate", "", "numberWay", "kmWay", "picket", "type1", "type2", "photo1", "photo2", "comment", "flag_edited", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PlatformRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<dev.fabula.android.platform.model.Platform>> allPlatforms = null;
    private final dev.fabula.android.platform.dao.PlatformDao platformDao = null;
    private final dev.fabula.android.canopy.dao.CanopyDao canopyDao = null;
    private final dev.fabula.android.support.dao.SupportDao supportDao = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<dev.fabula.android.platform.model.Platform>> getAllPlatforms() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getPlatformsOfStationOrPeregon(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<dev.fabula.android.platform.model.Platform>> p1) {
        return null;
    }
    
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
    public final java.lang.Object getCanopyOfPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.canopy.model.Canopy> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object platformUpdate(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, @org.jetbrains.annotations.NotNull()
    java.lang.String numberWay, @org.jetbrains.annotations.NotNull()
    java.lang.String kmWay, @org.jetbrains.annotations.NotNull()
    java.lang.String picket, @org.jetbrains.annotations.NotNull()
    java.lang.String type1, @org.jetbrains.annotations.NotNull()
    java.lang.String type2, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2, @org.jetbrains.annotations.NotNull()
    java.lang.String comment, boolean flag_edited, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p10) {
        return null;
    }
    
    @javax.inject.Inject()
    public PlatformRepository(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.platform.dao.PlatformDao platformDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.canopy.dao.CanopyDao canopyDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.support.dao.SupportDao supportDao) {
        super();
    }
}