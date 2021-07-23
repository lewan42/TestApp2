package dev.fabula.android.measurements.create.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\r\u001a\u00020\u00072\n\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Ldev/fabula/android/measurements/create/adapter/CreateMeasurementsListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Ldev/fabula/android/measurements/model/BoschMeasurements;", "Ldev/fabula/android/measurements/create/adapter/CreateMeasurementsListAdapter$ViewHolder;", "()V", "onItemClick", "Lkotlin/Function1;", "", "Ldev/fabula/android/measurements/create/adapter/onItemClick;", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"})
public final class CreateMeasurementsListAdapter extends androidx.recyclerview.widget.ListAdapter<dev.fabula.android.measurements.model.BoschMeasurements, dev.fabula.android.measurements.create.adapter.CreateMeasurementsListAdapter.ViewHolder> {
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super dev.fabula.android.measurements.model.BoschMeasurements, kotlin.Unit> onItemClick;
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<dev.fabula.android.measurements.model.BoschMeasurements, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super dev.fabula.android.measurements.model.BoschMeasurements, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public dev.fabula.android.measurements.create.adapter.CreateMeasurementsListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.create.adapter.CreateMeasurementsListAdapter.ViewHolder holder, int position) {
    }
    
    public CreateMeasurementsListAdapter() {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Ldev/fabula/android/measurements/create/adapter/CreateMeasurementsListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ldev/fabula/android/databinding/CreateMeasurementItemListBinding;", "(Ldev/fabula/android/measurements/create/adapter/CreateMeasurementsListAdapter;Ldev/fabula/android/databinding/CreateMeasurementItemListBinding;)V", "getBinding", "()Ldev/fabula/android/databinding/CreateMeasurementItemListBinding;", "bind", "", "item", "Ldev/fabula/android/measurements/model/BoschMeasurements;", "pos", "", "app_release"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final dev.fabula.android.databinding.CreateMeasurementItemListBinding binding = null;
        
        @android.annotation.SuppressLint(value = {"SetTextI18n"})
        public final void bind(@org.jetbrains.annotations.NotNull()
        dev.fabula.android.measurements.model.BoschMeasurements item, int pos) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.fabula.android.databinding.CreateMeasurementItemListBinding getBinding() {
            return null;
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        dev.fabula.android.databinding.CreateMeasurementItemListBinding binding) {
            super(null);
        }
    }
}