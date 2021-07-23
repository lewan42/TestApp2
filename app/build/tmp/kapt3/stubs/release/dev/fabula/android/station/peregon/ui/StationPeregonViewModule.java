package dev.fabula.android.station.peregon.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J*\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Ldev/fabula/android/station/peregon/ui/StationPeregonViewModule;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/station/peregon/repo/StationPeregonRepository;", "(Ldev/fabula/android/station/peregon/repo/StationPeregonRepository;)V", "_station", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/station/peregon/model/StationPeregon;", "_stationUpdate", "Ldev/fabula/android/app/ui/Event;", "", "getRepository", "()Ldev/fabula/android/station/peregon/repo/StationPeregonRepository;", "station", "Landroidx/lifecycle/LiveData;", "getStation", "()Landroidx/lifecycle/LiveData;", "stationUpdate", "getStationUpdate", "stationPeregon", "", "uid", "", "stationPeregonUpdate", "uidStation", "comment", "photo1", "photo2", "app_release"})
public final class StationPeregonViewModule extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.station.peregon.model.StationPeregon> _station = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> _stationUpdate = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.fabula.android.station.peregon.repo.StationPeregonRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.station.peregon.model.StationPeregon> getStation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> getStationUpdate() {
        return null;
    }
    
    public final void stationPeregon(@org.jetbrains.annotations.NotNull()
    java.lang.String uid) {
    }
    
    public final void stationPeregonUpdate(@org.jetbrains.annotations.NotNull()
    java.lang.String uidStation, @org.jetbrains.annotations.NotNull()
    java.lang.String comment, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.fabula.android.station.peregon.repo.StationPeregonRepository getRepository() {
        return null;
    }
    
    @javax.inject.Inject()
    public StationPeregonViewModule(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.station.peregon.repo.StationPeregonRepository repository) {
        super();
    }
}