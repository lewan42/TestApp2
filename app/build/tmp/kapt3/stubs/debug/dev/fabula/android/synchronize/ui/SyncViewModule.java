package dev.fabula.android.synchronize.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\rR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Ldev/fabula/android/synchronize/ui/SyncViewModule;", "Ldev/fabula/android/app/ui/BaseViewModel;", "syncRepo", "Ldev/fabula/android/synchronize/repo/SyncRepository;", "(Ldev/fabula/android/synchronize/repo/SyncRepository;)V", "_sync", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/app/ui/Event;", "", "sync", "Landroidx/lifecycle/LiveData;", "getSync", "()Landroidx/lifecycle/LiveData;", "", "app_debug"})
public final class SyncViewModule extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> _sync = null;
    private final dev.fabula.android.synchronize.repo.SyncRepository syncRepo = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> getSync() {
        return null;
    }
    
    public final void sync() {
    }
    
    @javax.inject.Inject()
    public SyncViewModule(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.synchronize.repo.SyncRepository syncRepo) {
        super();
    }
}