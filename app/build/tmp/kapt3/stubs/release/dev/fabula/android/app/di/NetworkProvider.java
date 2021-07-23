package dev.fabula.android.app.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Ldev/fabula/android/app/di/NetworkProvider;", "Ldev/fabula/android/app/di/GsonProvider;", "provideBaseUrl", "", "provideHttpClient", "Lokhttp3/OkHttpClient;", "provideRetrofit", "Lretrofit2/Retrofit;", "app_release"})
public abstract interface NetworkProvider extends dev.fabula.android.app.di.GsonProvider {
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "base_url")
    public abstract java.lang.String provideBaseUrl();
    
    @org.jetbrains.annotations.NotNull()
    public abstract okhttp3.OkHttpClient provideHttpClient();
    
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Retrofit provideRetrofit();
}