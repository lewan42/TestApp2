package dev.fabula.android.app.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Ldev/fabula/android/app/di/PhoneProvider;", "", "providePhoneNumberUtil", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "app_release"})
public abstract interface PhoneProvider {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.michaelrocks.libphonenumber.android.PhoneNumberUtil providePhoneNumberUtil();
}