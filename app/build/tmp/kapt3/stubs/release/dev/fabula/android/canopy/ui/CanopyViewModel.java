package dev.fabula.android.canopy.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u0015\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJV\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001cR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R#\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006\'"}, d2 = {"Ldev/fabula/android/canopy/ui/CanopyViewModel;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/canopy/repo/CanopyRepository;", "(Ldev/fabula/android/canopy/repo/CanopyRepository;)V", "_canopy", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/app/ui/Event;", "Ldev/fabula/android/canopy/model/Canopy;", "_canopyForSave", "_measurementsOfCanopy", "", "Ldev/fabula/android/measurements/model/Measurement;", "_updateMeasurementOfCanopy", "", "canopy", "Landroidx/lifecycle/LiveData;", "getCanopy", "()Landroidx/lifecycle/LiveData;", "canopyForSave", "getCanopyForSave", "measurementsOfCanopy", "getMeasurementsOfCanopy", "updateMeasurementOfCanopy", "getUpdateMeasurementOfCanopy", "getCanopyById", "", "uidCanopy", "", "getCanopyByIdForSave", "uid1", "v1", "h1", "uid2", "v2", "h2", "uid3", "v3", "h3", "app_release"})
public final class CanopyViewModel extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.canopy.model.Canopy>> _canopy = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.canopy.model.Canopy>> _canopyForSave = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> _updateMeasurementOfCanopy = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.util.List<dev.fabula.android.measurements.model.Measurement>>> _measurementsOfCanopy = null;
    private final dev.fabula.android.canopy.repo.CanopyRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.canopy.model.Canopy>> getCanopy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.canopy.model.Canopy>> getCanopyForSave() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> getUpdateMeasurementOfCanopy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.util.List<dev.fabula.android.measurements.model.Measurement>>> getMeasurementsOfCanopy() {
        return null;
    }
    
    public final void measurementsOfCanopy(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy) {
    }
    
    public final void getCanopyById(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy) {
    }
    
    public final void getCanopyByIdForSave(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy) {
    }
    
    public final void updateMeasurementOfCanopy(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy, @org.jetbrains.annotations.NotNull()
    java.lang.String uid1, @org.jetbrains.annotations.NotNull()
    java.lang.String v1, @org.jetbrains.annotations.NotNull()
    java.lang.String h1, @org.jetbrains.annotations.NotNull()
    java.lang.String uid2, @org.jetbrains.annotations.NotNull()
    java.lang.String v2, @org.jetbrains.annotations.NotNull()
    java.lang.String h2, @org.jetbrains.annotations.NotNull()
    java.lang.String uid3, @org.jetbrains.annotations.NotNull()
    java.lang.String v3, @org.jetbrains.annotations.NotNull()
    java.lang.String h3) {
    }
    
    @javax.inject.Inject()
    public CanopyViewModel(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.canopy.repo.CanopyRepository repository) {
        super();
    }
}