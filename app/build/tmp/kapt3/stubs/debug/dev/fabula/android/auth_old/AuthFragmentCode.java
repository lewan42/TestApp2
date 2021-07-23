package dev.fabula.android.auth_old;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\u001a\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\""}, d2 = {"Ldev/fabula/android/auth_old/AuthFragmentCode;", "Ldev/fabula/android/app/ui/ViewModelFragment;", "Ldev/fabula/android/databinding/AuthFragmentCodeBinding;", "()V", "retrySendTime", "Ljava/util/Date;", "viewModel", "Ldev/fabula/android/auth_old/AuthViewModel;", "getViewModel", "()Ldev/fabula/android/auth_old/AuthViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkCode", "", "checkTimer", "newTimerTick", "", "next_task_time", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onClickNext", "onClickRetry", "onCodeSuccess", "onSendCode", "onViewCreated", "view", "Landroid/view/View;", "showProgress", "progress", "app_debug"})
public final class AuthFragmentCode extends dev.fabula.android.app.ui.ViewModelFragment<dev.fabula.android.databinding.AuthFragmentCodeBinding> {
    private java.util.Date retrySendTime;
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    private final dev.fabula.android.auth_old.AuthViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showProgress(boolean progress) {
    }
    
    private final void onCodeSuccess() {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean checkTimer() {
        return false;
    }
    
    private final void onClickRetry() {
    }
    
    private final boolean checkCode() {
        return false;
    }
    
    private final void onClickNext() {
    }
    
    private final void onSendCode() {
    }
    
    private final java.lang.String newTimerTick(java.util.Date next_task_time) {
        return null;
    }
    
    public AuthFragmentCode() {
        super();
    }
}