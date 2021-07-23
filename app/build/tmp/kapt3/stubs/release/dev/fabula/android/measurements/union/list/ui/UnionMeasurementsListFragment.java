package dev.fabula.android.measurements.union.list.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Ldev/fabula/android/measurements/union/list/ui/UnionMeasurementsListFragment;", "Ldev/fabula/android/app/ui/ViewModelFragment;", "Ldev/fabula/android/databinding/UnionMeasurementListFragmentBinding;", "()V", "adapter", "Ldev/fabula/android/measurements/union/list/adapter/UnionMeasurementListAdapter;", "existMeasurements", "", "Ldev/fabula/android/measurements/model/Measurement;", "viewModel", "Ldev/fabula/android/measurements/union/list/ui/UnionMeasurementsListViewModel;", "getViewModel", "()Ldev/fabula/android/measurements/union/list/ui/UnionMeasurementsListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelCamera", "Ldev/fabula/android/camera/CameraViewModel;", "getViewModelCamera", "()Ldev/fabula/android/camera/CameraViewModel;", "viewModelCamera$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"})
public final class UnionMeasurementsListFragment extends dev.fabula.android.app.ui.ViewModelFragment<dev.fabula.android.databinding.UnionMeasurementListFragmentBinding> {
    private dev.fabula.android.measurements.union.list.adapter.UnionMeasurementListAdapter adapter;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy viewModelCamera$delegate = null;
    private java.util.List<dev.fabula.android.measurements.model.Measurement> existMeasurements;
    private java.util.HashMap _$_findViewCache;
    
    private final dev.fabula.android.measurements.union.list.ui.UnionMeasurementsListViewModel getViewModel() {
        return null;
    }
    
    private final dev.fabula.android.camera.CameraViewModel getViewModelCamera() {
        return null;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public UnionMeasurementsListFragment() {
        super();
    }
}