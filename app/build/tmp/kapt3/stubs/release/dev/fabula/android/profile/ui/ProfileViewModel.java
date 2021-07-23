package dev.fabula.android.profile.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Ldev/fabula/android/profile/ui/ProfileViewModel;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/synchronize/repo/SyncRepository;", "auth", "Ldev/fabula/android/auth_old/AppAuth;", "(Ldev/fabula/android/synchronize/repo/SyncRepository;Ldev/fabula/android/auth_old/AppAuth;)V", "_deleteAllData", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/app/ui/Event;", "", "_isNotSyncData", "deleteAllData", "Landroidx/lifecycle/LiveData;", "getDeleteAllData", "()Landroidx/lifecycle/LiveData;", "isNotSyncData", "checkNotSyncData", "", "deleteAll", "exit", "getEmailName", "", "app_release"})
public final class ProfileViewModel extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> _isNotSyncData = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> _deleteAllData = null;
    private final dev.fabula.android.synchronize.repo.SyncRepository repository = null;
    private final dev.fabula.android.auth_old.AppAuth auth = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> isNotSyncData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> getDeleteAllData() {
        return null;
    }
    
    public final void checkNotSyncData() {
    }
    
    public final void deleteAll() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmailName() {
        return null;
    }
    
    public final void exit() {
    }
    
    @javax.inject.Inject()
    public ProfileViewModel(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.synchronize.repo.SyncRepository repository, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.auth_old.AppAuth auth) {
        super();
    }
}