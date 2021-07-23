package dev.fabula.android.screen.measurements.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Ldev/fabula/android/screen/measurements/repo/ScreenMeasurementsRepository;", "", "stationPeregonDao", "Ldev/fabula/android/station/peregon/dao/StationPeregonDao;", "supportDao", "Ldev/fabula/android/support/dao/SupportDao;", "(Ldev/fabula/android/station/peregon/dao/StationPeregonDao;Ldev/fabula/android/support/dao/SupportDao;)V", "allStationPeregonsAndSupports", "", "Ldev/fabula/android/screen/measurements/model/ListItem;", "idRailwaySection", "", "filterType", "query", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stationPeregonToItem", "station", "Ldev/fabula/android/station/peregon/model/StationPeregon;", "supportToItem", "support", "Ldev/fabula/android/support/model/Support;", "app_release"})
public final class ScreenMeasurementsRepository {
    private final dev.fabula.android.station.peregon.dao.StationPeregonDao stationPeregonDao = null;
    private final dev.fabula.android.support.dao.SupportDao supportDao = null;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object allStationPeregonsAndSupports(@org.jetbrains.annotations.NotNull()
    java.lang.String idRailwaySection, @org.jetbrains.annotations.Nullable()
    java.lang.String filterType, @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<dev.fabula.android.screen.measurements.model.ListItem>> p3) {
        return null;
    }
    
    private final dev.fabula.android.screen.measurements.model.ListItem supportToItem(dev.fabula.android.support.model.Support support) {
        return null;
    }
    
    private final dev.fabula.android.screen.measurements.model.ListItem stationPeregonToItem(dev.fabula.android.station.peregon.model.StationPeregon station) {
        return null;
    }
    
    @javax.inject.Inject()
    public ScreenMeasurementsRepository(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.station.peregon.dao.StationPeregonDao stationPeregonDao, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.support.dao.SupportDao supportDao) {
        super();
    }
}