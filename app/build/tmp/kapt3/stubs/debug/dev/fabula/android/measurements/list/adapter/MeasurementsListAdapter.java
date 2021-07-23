package dev.fabula.android.measurements.list.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u000f\u001a\u00020\t2\n\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R.\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Ldev/fabula/android/measurements/list/adapter/MeasurementsListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Ldev/fabula/android/measurements/model/Measurement;", "Ldev/fabula/android/measurements/list/adapter/MeasurementsListAdapter$ViewHolder;", "objMeasure", "", "(Ljava/lang/String;)V", "onItemClick", "Lkotlin/Function1;", "", "Ldev/fabula/android/measurements/list/adapter/onItemClick;", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class MeasurementsListAdapter extends androidx.recyclerview.widget.ListAdapter<dev.fabula.android.measurements.model.Measurement, dev.fabula.android.measurements.list.adapter.MeasurementsListAdapter.ViewHolder> {
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super dev.fabula.android.measurements.model.Measurement, kotlin.Unit> onItemClick;
    private final java.lang.String objMeasure = null;
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<dev.fabula.android.measurements.model.Measurement, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super dev.fabula.android.measurements.model.Measurement, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public dev.fabula.android.measurements.list.adapter.MeasurementsListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.list.adapter.MeasurementsListAdapter.ViewHolder holder, int position) {
    }
    
    public MeasurementsListAdapter(@org.jetbrains.annotations.NotNull()
    java.lang.String objMeasure) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Ldev/fabula/android/measurements/list/adapter/MeasurementsListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ldev/fabula/android/databinding/MeasureListFragmentItemBinding;", "(Ldev/fabula/android/measurements/list/adapter/MeasurementsListAdapter;Ldev/fabula/android/databinding/MeasureListFragmentItemBinding;)V", "getBinding", "()Ldev/fabula/android/databinding/MeasureListFragmentItemBinding;", "bind", "", "item", "Ldev/fabula/android/measurements/model/Measurement;", "pos", "", "objMeasure", "", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final dev.fabula.android.databinding.MeasureListFragmentItemBinding binding = null;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        dev.fabula.android.measurements.model.Measurement item, int pos, @org.jetbrains.annotations.NotNull()
        java.lang.String objMeasure) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.fabula.android.databinding.MeasureListFragmentItemBinding getBinding() {
            return null;
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        dev.fabula.android.databinding.MeasureListFragmentItemBinding binding) {
            super(null);
        }
    }
}