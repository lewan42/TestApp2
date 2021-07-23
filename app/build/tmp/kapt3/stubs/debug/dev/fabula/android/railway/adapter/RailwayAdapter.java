package dev.fabula.android.railway.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\r\u001a\u00020\u00072\n\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Ldev/fabula/android/railway/adapter/RailwayAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Ldev/fabula/android/railway/model/Railway;", "Ldev/fabula/android/railway/adapter/RailwayAdapter$ViewHolder;", "()V", "onItemClick", "Lkotlin/Function1;", "", "Ldev/fabula/android/railway/adapter/OnItemClick;", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class RailwayAdapter extends androidx.recyclerview.widget.ListAdapter<dev.fabula.android.railway.model.Railway, dev.fabula.android.railway.adapter.RailwayAdapter.ViewHolder> {
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super dev.fabula.android.railway.model.Railway, kotlin.Unit> onItemClick;
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<dev.fabula.android.railway.model.Railway, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super dev.fabula.android.railway.model.Railway, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public dev.fabula.android.railway.adapter.RailwayAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.railway.adapter.RailwayAdapter.ViewHolder holder, int position) {
    }
    
    public RailwayAdapter() {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Ldev/fabula/android/railway/adapter/RailwayAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ldev/fabula/android/databinding/RailwayItemBinding;", "(Ldev/fabula/android/railway/adapter/RailwayAdapter;Ldev/fabula/android/databinding/RailwayItemBinding;)V", "getBinding", "()Ldev/fabula/android/databinding/RailwayItemBinding;", "bind", "", "item", "Ldev/fabula/android/railway/model/Railway;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final dev.fabula.android.databinding.RailwayItemBinding binding = null;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        dev.fabula.android.railway.model.Railway item) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.fabula.android.databinding.RailwayItemBinding getBinding() {
            return null;
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        dev.fabula.android.databinding.RailwayItemBinding binding) {
            super(null);
        }
    }
}