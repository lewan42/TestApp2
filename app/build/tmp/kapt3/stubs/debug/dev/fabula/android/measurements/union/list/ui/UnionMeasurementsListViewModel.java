package dev.fabula.android.measurements.union.list.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u0015\u001a\u00020\u0019J\u0006\u0010\u0017\u001a\u00020\u0019J\u0016\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Ldev/fabula/android/measurements/union/list/ui/UnionMeasurementsListViewModel;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/measurements/union/list/repo/UnionMeasurementsRepository;", "(Ldev/fabula/android/measurements/union/list/repo/UnionMeasurementsRepository;)V", "_data", "Landroidx/lifecycle/MutableLiveData;", "", "Ldev/fabula/android/bosch/otg/model/BoschOtgItemList;", "_isPhotoUpdate", "Ldev/fabula/android/app/ui/Event;", "", "_measurements", "Ldev/fabula/android/measurements/model/Measurement;", "_measurements2", "data", "Landroidx/lifecycle/LiveData;", "getData", "()Landroidx/lifecycle/LiveData;", "isPhotoUpdate", "measurements", "getMeasurements", "measurements2", "getMeasurements2", "getDataFromBoschDevice", "", "file", "Ljava/io/File;", "context", "Landroid/content/Context;", "photoUpdate", "uid", "", "photo", "app_debug"})
public final class UnionMeasurementsListViewModel extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<java.util.List<dev.fabula.android.measurements.model.Measurement>> _measurements = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<dev.fabula.android.measurements.model.Measurement>> _measurements2 = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<dev.fabula.android.bosch.otg.model.BoschOtgItemList>> _data = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> _isPhotoUpdate = null;
    private final dev.fabula.android.measurements.union.list.repo.UnionMeasurementsRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.measurements.model.Measurement>> getMeasurements() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.measurements.model.Measurement>> getMeasurements2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.bosch.otg.model.BoschOtgItemList>> getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> isPhotoUpdate() {
        return null;
    }
    
    public final void photoUpdate(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String photo) {
    }
    
    public final void getMeasurements() {
    }
    
    public final void getMeasurements2() {
    }
    
    public final void getDataFromBoschDevice(@org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @javax.inject.Inject()
    public UnionMeasurementsListViewModel(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.union.list.repo.UnionMeasurementsRepository repository) {
        super();
    }
}