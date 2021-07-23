package dev.fabula.android.app.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2 = {"Ldev/fabula/android/app/di/PhoneModule;", "", "()V", "providePhoneNumberUtil", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "app_release"})
@dagger.Module()
public final class PhoneModule {
    
    @dagger.Provides()
    @dagger.Reusable()
    public final io.michaelrocks.libphonenumber.android.PhoneNumberUtil providePhoneNumberUtil(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public PhoneModule() {
        super();
    }
}