package dev.fabula.android.auth_old;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\rJ\u001e\u0010\u0018\u001a\u00020\n2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0002J\u0016\u0010\u001c\u001a\u00020\n2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#J\u001e\u0010\u001c\u001a\u00020\n2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\f0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR+\u0010\u001c\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\f0\t0\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b\u00a8\u0006$"}, d2 = {"Ldev/fabula/android/auth_old/AuthViewModel;", "Ldev/fabula/android/app/ui/BaseViewModel;", "retrofit", "Lretrofit2/Retrofit;", "auth", "Ldev/fabula/android/auth_old/AppAuth;", "(Lretrofit2/Retrofit;Ldev/fabula/android/auth_old/AppAuth;)V", "_validateCode", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/app/ui/Event;", "", "_validatePhone", "", "", "getAuth", "()Ldev/fabula/android/auth_old/AppAuth;", "getRetrofit", "()Lretrofit2/Retrofit;", "service", "Ldev/fabula/android/auth_old/remote/AuthService;", "getService", "()Ldev/fabula/android/auth_old/remote/AuthService;", "service$delegate", "Lkotlin/Lazy;", "validateCode", "Landroidx/lifecycle/LiveData;", "getValidateCode", "()Landroidx/lifecycle/LiveData;", "validatePhone", "getValidatePhone", "tryCode", "code", "params", "phone", "agree", "", "app_release"})
public final class AuthViewModel extends dev.fabula.android.app.ui.BaseViewModel {
    private final kotlin.Lazy service$delegate = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.util.Map<java.lang.String, java.lang.String>>> _validatePhone = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<kotlin.Unit>> _validateCode = null;
    @org.jetbrains.annotations.NotNull()
    private final retrofit2.Retrofit retrofit = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.fabula.android.auth_old.AppAuth auth = null;
    
    private final dev.fabula.android.auth_old.remote.AuthService getService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.util.Map<java.lang.String, java.lang.String>>> getValidatePhone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<kotlin.Unit>> getValidateCode() {
        return null;
    }
    
    public final void validatePhone(@org.jetbrains.annotations.NotNull()
    java.lang.String phone, boolean agree) {
    }
    
    private final void validatePhone(java.util.Map<java.lang.String, java.lang.String> params) {
    }
    
    public final void tryCode() {
    }
    
    public final void validateCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code) {
    }
    
    private final void validateCode(java.util.Map<java.lang.String, java.lang.String> params) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.fabula.android.auth_old.AppAuth getAuth() {
        return null;
    }
    
    @javax.inject.Inject()
    public AuthViewModel(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.auth_old.AppAuth auth) {
        super();
    }
}