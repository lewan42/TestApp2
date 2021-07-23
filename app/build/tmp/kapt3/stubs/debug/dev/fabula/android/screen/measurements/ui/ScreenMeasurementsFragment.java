package dev.fabula.android.screen.measurements.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2 = {"Ldev/fabula/android/screen/measurements/ui/ScreenMeasurementsFragment;", "Ldev/fabula/android/app/ui/ViewModelFragment;", "Ldev/fabula/android/databinding/ScreenMeasurementsFragmentBinding;", "()V", "FILTER_QUERY", "", "FILTER_TYPE", "adapter", "Ldev/fabula/android/screen/measurements/adapter/ScreenMeasurementsAdapter;", "railway", "Ldev/fabula/android/railway/model/Railway;", "getRailway", "()Ldev/fabula/android/railway/model/Railway;", "railwaySection", "Ldev/fabula/android/section/model/RailwaySection;", "getRailwaySection", "()Ldev/fabula/android/section/model/RailwaySection;", "viewModel", "Ldev/fabula/android/screen/measurements/ui/ScreenMeasurementsViewModule;", "getViewModel", "()Ldev/fabula/android/screen/measurements/ui/ScreenMeasurementsViewModule;", "viewModel$delegate", "Lkotlin/Lazy;", "fetchData", "", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ScreenMeasurementsFragment extends dev.fabula.android.app.ui.ViewModelFragment<dev.fabula.android.databinding.ScreenMeasurementsFragmentBinding> {
    private dev.fabula.android.screen.measurements.adapter.ScreenMeasurementsAdapter adapter;
    private final kotlin.Lazy viewModel$delegate = null;
    private java.lang.String FILTER_QUERY = "";
    private java.lang.String FILTER_TYPE;
    private java.util.HashMap _$_findViewCache;
    
    private final dev.fabula.android.railway.model.Railway getRailway() {
        return null;
    }
    
    private final dev.fabula.android.section.model.RailwaySection getRailwaySection() {
        return null;
    }
    
    private final dev.fabula.android.screen.measurements.ui.ScreenMeasurementsViewModule getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void fetchData() {
    }
    
    public ScreenMeasurementsFragment() {
        super();
    }
}