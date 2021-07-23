package dev.fabula.android.app.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0004B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\n\b\u0001\u0010\u0010\u0018\u0001*\u00020\u0011H\u0084\bJ\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\n\b\u0001\u0010\u0010\u0018\u0001*\u00020\u0011H\u0084\bR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Ldev/fabula/android/app/ui/ViewModelFragment;", "V", "Landroidx/viewbinding/ViewBinding;", "Ldev/fabula/android/app/ui/ViewBindingFragment;", "()V", "contentLayoutId", "", "(I)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "activityViewModel", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "viewModel", "app_debug"})
public abstract class ViewModelFragment<V extends androidx.viewbinding.ViewBinding> extends dev.fabula.android.app.ui.ViewBindingFragment<V> {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public androidx.lifecycle.ViewModelProvider.Factory viewModelFactory;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.ViewModelProvider.Factory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.ViewModelProvider.Factory p0) {
    }
    
    public ViewModelFragment() {
        super();
    }
    
    public ViewModelFragment(@androidx.annotation.LayoutRes()
    int contentLayoutId) {
        super();
    }
}