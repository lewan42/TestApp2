package dev.fabula.android.app.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00102\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u000f\u0010J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH\'J\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u0011"}, d2 = {"Ldev/fabula/android/app/di/AppComponent;", "Ldev/fabula/android/app/di/PhoneProvider;", "Ldev/fabula/android/app/di/NetworkProvider;", "Ldev/fabula/android/app/di/GlideProvider;", "Ldev/fabula/android/app/di/DatabaseProvider;", "inject", "", "activity", "Ldev/fabula/android/app/ui/AppActivity;", "fragment", "Ldev/fabula/android/splash/SplashFragment;", "provideAuth", "Ldev/fabula/android/auth_old/AppAuth;", "provideContext", "Landroid/content/Context;", "Builder", "Companion", "app_release"})
@dagger.Component(modules = {dev.fabula.android.app.di.PhoneModule.class, dev.fabula.android.app.di.GlideModule.class, dev.fabula.android.app.di.GsonModule.class, dev.fabula.android.app.di.NetworkModule.class, dev.fabula.android.app.di.DatabaseModule.class})
public abstract interface AppComponent extends dev.fabula.android.app.di.PhoneProvider, dev.fabula.android.app.di.NetworkProvider, dev.fabula.android.app.di.GlideProvider, dev.fabula.android.app.di.DatabaseProvider {
    public static final dev.fabula.android.app.di.AppComponent.Companion Companion = null;
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.app.ui.AppActivity activity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.splash.SplashFragment fragment);
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.content.Context provideContext();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Reusable()
    public abstract dev.fabula.android.auth_old.AppAuth provideAuth();
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\'J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Ldev/fabula/android/app/di/AppComponent$Builder;", "", "application", "context", "Landroid/content/Context;", "build", "Ldev/fabula/android/app/di/AppComponent;", "app_release"})
    @dagger.Component.Builder()
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract dev.fabula.android.app.di.AppComponent.Builder application(@org.jetbrains.annotations.NotNull()
        android.content.Context context);
        
        @org.jetbrains.annotations.NotNull()
        public abstract dev.fabula.android.app.di.AppComponent build();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Ldev/fabula/android/app/di/AppComponent$Companion;", "", "()V", "create", "Ldev/fabula/android/app/di/AppComponent;", "context", "Landroid/content/Context;", "app_release"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final dev.fabula.android.app.di.AppComponent create(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}