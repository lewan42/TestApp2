package dev.fabula.android.auth.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Ldev/fabula/android/auth/ui/AuthViewModel;", "Ldev/fabula/android/app/ui/BaseViewModel;", "retrofit", "Lretrofit2/Retrofit;", "auth", "Ldev/fabula/android/auth_old/AppAuth;", "syncRepo", "Ldev/fabula/android/synchronize/repo/SyncRepository;", "(Lretrofit2/Retrofit;Ldev/fabula/android/auth_old/AppAuth;Ldev/fabula/android/synchronize/repo/SyncRepository;)V", "_singIn", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/app/ui/Event;", "", "getAuth", "()Ldev/fabula/android/auth_old/AppAuth;", "getRetrofit", "()Lretrofit2/Retrofit;", "service", "Ldev/fabula/android/auth/remote/AuthService;", "getService", "()Ldev/fabula/android/auth/remote/AuthService;", "service$delegate", "Lkotlin/Lazy;", "singIn", "Landroidx/lifecycle/LiveData;", "getSingIn", "()Landroidx/lifecycle/LiveData;", "trySingIn", "", "email", "", "password", "app_debug"})
public final class AuthViewModel extends dev.fabula.android.app.ui.BaseViewModel {
    private final kotlin.Lazy service$delegate = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> _singIn = null;
    @org.jetbrains.annotations.NotNull()
    private final retrofit2.Retrofit retrofit = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.fabula.android.auth_old.AppAuth auth = null;
    private final dev.fabula.android.synchronize.repo.SyncRepository syncRepo = null;
    
    private final dev.fabula.android.auth.remote.AuthService getService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> getSingIn() {
        return null;
    }
    
    public final void trySingIn(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
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
    dev.fabula.android.auth_old.AppAuth auth, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.synchronize.repo.SyncRepository syncRepo) {
        super();
    }
}