package dev.fabula.android.measurements.create.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\bJ\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aJ\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR&\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Ldev/fabula/android/measurements/create/ui/CreateMeasurementsViewModel;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/measurements/create/repo/CreateMeasurementsRepository;", "(Ldev/fabula/android/measurements/create/repo/CreateMeasurementsRepository;)V", "_measurement", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/app/ui/Event;", "Ldev/fabula/android/measurements/model/Measurement;", "_measurementInsert", "", "measurement", "Landroidx/lifecycle/LiveData;", "getMeasurement", "()Landroidx/lifecycle/LiveData;", "measurementInsert", "getMeasurementInsert", "objectMeasurement", "Ldev/fabula/android/bosch/otg/model/BoschOtgItemList;", "getObjectMeasurement", "()Landroidx/lifecycle/MutableLiveData;", "setObjectMeasurement", "(Landroidx/lifecycle/MutableLiveData;)V", "create", "", "measurements", "", "createDimensionAndMeasurement", "dimensionsFence", "Ldev/fabula/android/dimensions/fence/model/DimensionsFence;", "getMeasurementById", "uid", "", "app_debug"})
public final class CreateMeasurementsViewModel extends dev.fabula.android.app.ui.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.bosch.otg.model.BoschOtgItemList>> objectMeasurement;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.measurements.model.Measurement>> _measurement = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> _measurementInsert = null;
    private final dev.fabula.android.measurements.create.repo.CreateMeasurementsRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.bosch.otg.model.BoschOtgItemList>> getObjectMeasurement() {
        return null;
    }
    
    public final void setObjectMeasurement(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.bosch.otg.model.BoschOtgItemList>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.measurements.model.Measurement>> getMeasurement() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> getMeasurementInsert() {
        return null;
    }
    
    public final void create(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.model.Measurement measurement) {
    }
    
    public final void create(@org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.measurements.model.Measurement> measurements) {
    }
    
    public final void createDimensionAndMeasurement(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.model.Measurement measurement, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.dimensions.fence.model.DimensionsFence dimensionsFence) {
    }
    
    public final void getMeasurementById(@org.jetbrains.annotations.NotNull()
    java.lang.String uid) {
    }
    
    @javax.inject.Inject()
    public CreateMeasurementsViewModel(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.create.repo.CreateMeasurementsRepository repository) {
        super();
    }
}