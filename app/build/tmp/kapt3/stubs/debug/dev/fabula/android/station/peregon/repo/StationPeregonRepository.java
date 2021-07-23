package dev.fabula.android.station.peregon.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ5\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Ldev/fabula/android/station/peregon/repo/StationPeregonRepository;", "", "stationPeregonDao", "Ldev/fabula/android/station/peregon/dao/StationPeregonDao;", "(Ldev/fabula/android/station/peregon/dao/StationPeregonDao;)V", "getStationPeregonById", "Ldev/fabula/android/station/peregon/model/StationPeregon;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stationUpdate", "", "uidStation", "comment", "photo1", "photo2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class StationPeregonRepository {
    private final dev.fabula.android.station.peregon.dao.StationPeregonDao stationPeregonDao = null;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getStationPeregonById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.station.peregon.model.StationPeregon> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object stationUpdate(@org.jetbrains.annotations.NotNull()
    java.lang.String uidStation, @org.jetbrains.annotations.NotNull()
    java.lang.String comment, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p4) {
        return null;
    }
    
    @javax.inject.Inject()
    public StationPeregonRepository(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.station.peregon.dao.StationPeregonDao stationPeregonDao) {
        super();
    }
}