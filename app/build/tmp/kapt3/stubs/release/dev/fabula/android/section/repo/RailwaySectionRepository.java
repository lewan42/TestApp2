package dev.fabula.android.section.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\f\u001a\u00020\rH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Ldev/fabula/android/section/repo/RailwaySectionRepository;", "", "railwaySectionDao", "Ldev/fabula/android/section/dao/RailwaySectionDao;", "(Ldev/fabula/android/section/dao/RailwaySectionDao;)V", "allRailwaySections", "Lkotlinx/coroutines/flow/Flow;", "", "Ldev/fabula/android/section/model/RailwaySection;", "getAllRailwaySections", "()Lkotlinx/coroutines/flow/Flow;", "getRailwaySections", "uid_railway", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class RailwaySectionRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<dev.fabula.android.section.model.RailwaySection>> allRailwaySections = null;
    private final dev.fabula.android.section.dao.RailwaySectionDao railwaySectionDao = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<dev.fabula.android.section.model.RailwaySection>> getAllRailwaySections() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getRailwaySections(@org.jetbrains.annotations.NotNull()
    java.lang.String uid_railway, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<dev.fabula.android.section.model.RailwaySection>> p1) {
        return null;
    }
    
    @javax.inject.Inject()
    public RailwaySectionRepository(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.section.dao.RailwaySectionDao railwaySectionDao) {
        super();
    }
}