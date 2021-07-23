package dev.fabula.android.auth_old;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u001a\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006 "}, d2 = {"Ldev/fabula/android/auth_old/AuthFragmentPhone;", "Ldev/fabula/android/app/ui/ViewModelFragment;", "Ldev/fabula/android/databinding/AuthFragmentPhoneBinding;", "()V", "formattedNumber", "", "phoneUtil", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "getPhoneUtil", "()Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "setPhoneUtil", "(Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;)V", "viewModel", "Ldev/fabula/android/auth_old/AuthViewModel;", "getViewModel", "()Ldev/fabula/android/auth_old/AuthViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkInput", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onClickGetCard", "onViewCreated", "view", "Landroid/view/View;", "tryCode", "app_release"})
public final class AuthFragmentPhone extends dev.fabula.android.app.ui.ViewModelFragment<dev.fabula.android.databinding.AuthFragmentPhoneBinding> {
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public io.michaelrocks.libphonenumber.android.PhoneNumberUtil phoneUtil;
    private java.lang.String formattedNumber;
    private java.util.HashMap _$_findViewCache;
    
    private final dev.fabula.android.auth_old.AuthViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.michaelrocks.libphonenumber.android.PhoneNumberUtil getPhoneUtil() {
        return null;
    }
    
    public final void setPhoneUtil(@org.jetbrains.annotations.NotNull()
    io.michaelrocks.libphonenumber.android.PhoneNumberUtil p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean checkInput() {
        return false;
    }
    
    private final void onClickGetCard() {
    }
    
    private final void tryCode() {
    }
    
    public AuthFragmentPhone() {
        super();
    }
}