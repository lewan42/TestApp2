package dev.fabula.android.bridge.crossing.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Ldev/fabula/android/bridge/crossing/ui/BridgeViewModule;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/bridge/crossing/repo/BridgeRepository;", "(Ldev/fabula/android/bridge/crossing/repo/BridgeRepository;)V", "_createBridge", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/app/ui/Event;", "", "createBridge", "Landroidx/lifecycle/LiveData;", "getCreateBridge", "()Landroidx/lifecycle/LiveData;", "", "uidPlatform", "app_debug"})
public final class BridgeViewModule extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.String>> _createBridge = null;
    private final dev.fabula.android.bridge.crossing.repo.BridgeRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.String>> getCreateBridge() {
        return null;
    }
    
    public final void createBridge(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform) {
    }
    
    @javax.inject.Inject()
    public BridgeViewModule(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.bridge.crossing.repo.BridgeRepository repository) {
        super();
    }
}