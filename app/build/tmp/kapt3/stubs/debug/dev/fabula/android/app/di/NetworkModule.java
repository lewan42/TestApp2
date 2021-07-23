package dev.fabula.android.app.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\"\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u00a8\u0006\u001a"}, d2 = {"Ldev/fabula/android/app/di/NetworkModule;", "", "()V", "getCache", "Lokhttp3/Cache;", "context", "Landroid/content/Context;", "provideAuthInterceptor", "Lokhttp3/Interceptor;", "auth", "Ldev/fabula/android/auth_old/AppAuth;", "provideBaseUrl", "", "provideCacheInterceptor", "provideErrorsInterceptor", "provideHttpClient", "Lokhttp3/OkHttpClient;", "provideLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "provideOfflineCacheInterceptor", "provideRetrofit", "Lretrofit2/Retrofit;", "baseUrl", "client", "converter", "Lcom/google/gson/Gson;", "app_debug"})
@dagger.Module()
public final class NetworkModule {
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "base_url")
    @dagger.Provides()
    @dagger.Reusable()
    public final java.lang.String provideBaseUrl(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @dagger.Reusable()
    public final okhttp3.OkHttpClient provideHttpClient(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.auth_old.AppAuth auth) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @dagger.Reusable()
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "base_url")
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson converter) {
        return null;
    }
    
    private final okhttp3.logging.HttpLoggingInterceptor provideLoggingInterceptor() {
        return null;
    }
    
    private final okhttp3.Cache getCache(android.content.Context context) {
        return null;
    }
    
    private final okhttp3.Interceptor provideOfflineCacheInterceptor() {
        return null;
    }
    
    private final okhttp3.Interceptor provideCacheInterceptor() {
        return null;
    }
    
    private final okhttp3.Interceptor provideAuthInterceptor(dev.fabula.android.auth_old.AppAuth auth) {
        return null;
    }
    
    private final okhttp3.Interceptor provideErrorsInterceptor() {
        return null;
    }
    
    public NetworkModule() {
        super();
    }
}