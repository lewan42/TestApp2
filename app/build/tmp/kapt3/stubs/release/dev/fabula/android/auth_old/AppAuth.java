package dev.fabula.android.auth_old;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Ldev/fabula/android/auth_old/AppAuth;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "storage", "Landroid/content/SharedPreferences;", "<set-?>", "Ldev/fabula/android/auth_old/User;", "user", "getUser", "()Ldev/fabula/android/auth_old/User;", "changeUser", "", "login", "", "token", "name", "getUserEmail", "getUserID", "reload", "signIn", "bearer", "signOut", "app_release"})
public final class AppAuth {
    private final android.content.SharedPreferences storage = null;
    @org.jetbrains.annotations.Nullable()
    private dev.fabula.android.auth_old.User user;
    
    @org.jetbrains.annotations.Nullable()
    public final dev.fabula.android.auth_old.User getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserID() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserEmail() {
        return null;
    }
    
    public final void reload() {
    }
    
    public final void signIn(@org.jetbrains.annotations.NotNull()
    java.lang.String bearer) {
    }
    
    public final void signOut() {
    }
    
    public final void changeUser(@org.jetbrains.annotations.Nullable()
    java.lang.String login, @org.jetbrains.annotations.Nullable()
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
    }
    
    @javax.inject.Inject()
    public AppAuth(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}