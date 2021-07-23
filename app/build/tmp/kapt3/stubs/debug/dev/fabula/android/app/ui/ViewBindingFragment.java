package dev.fabula.android.app.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0004B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ldev/fabula/android/app/ui/ViewBindingFragment;", "V", "Landroidx/viewbinding/ViewBinding;", "Ldev/fabula/android/app/ui/BaseFragment;", "()V", "contentLayoutId", "", "(I)V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "onDestroyView", "", "app_debug"})
public abstract class ViewBindingFragment<V extends androidx.viewbinding.ViewBinding> extends dev.fabula.android.app.ui.BaseFragment {
    @org.jetbrains.annotations.Nullable()
    private V binding;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    protected final V getBinding() {
        return null;
    }
    
    protected final void setBinding(@org.jetbrains.annotations.Nullable()
    V p0) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    public ViewBindingFragment() {
        super();
    }
    
    public ViewBindingFragment(@androidx.annotation.LayoutRes()
    int contentLayoutId) {
        super();
    }
}