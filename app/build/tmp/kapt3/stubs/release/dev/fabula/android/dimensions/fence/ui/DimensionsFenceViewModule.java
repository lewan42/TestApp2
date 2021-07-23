package dev.fabula.android.dimensions.fence.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0007R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Ldev/fabula/android/dimensions/fence/ui/DimensionsFenceViewModule;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/dimensions/fence/repo/DimensionsFenceRepository;", "(Ldev/fabula/android/dimensions/fence/repo/DimensionsFenceRepository;)V", "_dimensionFence", "Landroidx/lifecycle/MutableLiveData;", "", "Ldev/fabula/android/dimensions/fence/model/DimensionsWithMeasure;", "_dimensionUpdate", "Ldev/fabula/android/app/ui/Event;", "", "_platform", "Ldev/fabula/android/platform/model/Platform;", "dimensionFence", "Landroidx/lifecycle/LiveData;", "getDimensionFence", "()Landroidx/lifecycle/LiveData;", "dimensionUpdate", "getDimensionUpdate", "platform", "getPlatform", "fetchDimensionList", "", "uidPlatform", "", "updateDimension", "list", "Ldev/fabula/android/dimensions/fence/model/DimensionSaveDB;", "app_release"})
public final class DimensionsFenceViewModule extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.platform.model.Platform> _platform = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsWithMeasure>> _dimensionFence = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> _dimensionUpdate = null;
    private final dev.fabula.android.dimensions.fence.repo.DimensionsFenceRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.platform.model.Platform> getPlatform() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsWithMeasure>> getDimensionFence() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> getDimensionUpdate() {
        return null;
    }
    
    public final void fetchDimensionList(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform) {
    }
    
    public final void updateDimension(@org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.dimensions.fence.model.DimensionSaveDB> list) {
    }
    
    @javax.inject.Inject()
    public DimensionsFenceViewModule(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.dimensions.fence.repo.DimensionsFenceRepository repository) {
        super();
    }
}