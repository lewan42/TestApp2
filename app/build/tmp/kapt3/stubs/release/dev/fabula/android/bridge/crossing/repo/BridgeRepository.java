package dev.fabula.android.bridge.crossing.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Ldev/fabula/android/bridge/crossing/repo/BridgeRepository;", "", "platformDao", "Ldev/fabula/android/platform/dao/PlatformDao;", "supportDao", "Ldev/fabula/android/support/dao/SupportDao;", "bridgeCrossingDao", "Ldev/fabula/android/bridge/crossing/dao/BridgeCrossingDao;", "auth", "Ldev/fabula/android/auth_old/AppAuth;", "(Ldev/fabula/android/platform/dao/PlatformDao;Ldev/fabula/android/support/dao/SupportDao;Ldev/fabula/android/bridge/crossing/dao/BridgeCrossingDao;Ldev/fabula/android/auth_old/AppAuth;)V", "createBridge", "", "uidPlatform", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBridgeNameById", "uid", "getPlatformName", "getSupportsOfBridge", "", "Ldev/fabula/android/support/model/Support;", "uidBridge", "app_release"})
public final class BridgeRepository {
    private final dev.fabula.android.platform.dao.PlatformDao platformDao = null;
    private final dev.fabula.android.support.dao.SupportDao supportDao = null;
    private final dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao bridgeCrossingDao = null;
    private final dev.fabula.android.auth_old.AppAuth auth = null;
    
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
    public final java.lang.Object createBridge(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getBridgeNameById(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getSupportsOfBridge(@org.jetbrains.annotations.NotNull()
    java.lang.String uidBridge, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<dev.fabula.android.support.model.Support>> p1) {
        return null;
    }
    
    @javax.inject.Inject()
    public BridgeRepository(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.platform.dao.PlatformDao platformDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.support.dao.SupportDao supportDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao bridgeCrossingDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.auth_old.AppAuth auth) {
        super();
    }
}