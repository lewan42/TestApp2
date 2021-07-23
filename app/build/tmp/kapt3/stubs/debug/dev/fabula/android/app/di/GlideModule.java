package dev.fabula.android.app.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u000b"}, d2 = {"Ldev/fabula/android/app/di/GlideModule;", "", "()V", "provideRequestBuilder", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "imageLoader", "Lcom/bumptech/glide/RequestManager;", "provideRequestManager", "context", "Landroid/content/Context;", "app_debug"})
@dagger.Module()
public final class GlideModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.bumptech.glide.RequestManager provideRequestManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> provideRequestBuilder(@org.jetbrains.annotations.NotNull()
    com.bumptech.glide.RequestManager imageLoader) {
        return null;
    }
    
    public GlideModule() {
        super();
    }
}