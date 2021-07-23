package dev.fabula.android.platform.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJZ\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u001b2\b\u0010$\u001a\u0004\u0018\u00010\u001b2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\fR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011\u00a8\u0006\'"}, d2 = {"Ldev/fabula/android/platform/ui/PlatformViewModule;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/platform/repo/PlatformRepository;", "(Ldev/fabula/android/platform/repo/PlatformRepository;)V", "_canopy", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/app/ui/Event;", "Ldev/fabula/android/canopy/model/Canopy;", "_platform", "Ldev/fabula/android/platform/model/Platform;", "_platformUpdate", "", "_support", "canopy", "Landroidx/lifecycle/LiveData;", "getCanopy", "()Landroidx/lifecycle/LiveData;", "platform", "getPlatform", "platformUpdate", "getPlatformUpdate", "support", "getSupport", "getCanopyOfPlatform", "", "uidPlatform", "", "getPlatformById", "update", "numberWay", "kmWay", "picket", "type1", "type2", "photo1", "photo2", "comment", "flag_edited", "app_release"})
public final class PlatformViewModule extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.platform.model.Platform> _platform = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> _platformUpdate = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.canopy.model.Canopy>> _canopy = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.canopy.model.Canopy>> _support = null;
    private final dev.fabula.android.platform.repo.PlatformRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.platform.model.Platform> getPlatform() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> getPlatformUpdate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.canopy.model.Canopy>> getCanopy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.canopy.model.Canopy>> getSupport() {
        return null;
    }
    
    public final void getPlatformById(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform) {
    }
    
    public final void getCanopyOfPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform) {
    }
    
    public final void update(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, @org.jetbrains.annotations.NotNull()
    java.lang.String numberWay, @org.jetbrains.annotations.NotNull()
    java.lang.String kmWay, @org.jetbrains.annotations.NotNull()
    java.lang.String picket, @org.jetbrains.annotations.NotNull()
    java.lang.String type1, @org.jetbrains.annotations.NotNull()
    java.lang.String type2, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2, @org.jetbrains.annotations.NotNull()
    java.lang.String comment, boolean flag_edited) {
    }
    
    @javax.inject.Inject()
    public PlatformViewModule(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.platform.repo.PlatformRepository repository) {
        super();
    }
}