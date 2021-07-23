package dev.fabula.android.auth.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Ldev/fabula/android/auth/remote/AuthService;", "", "isValidToken", "Ldev/fabula/android/auth/remote/AuthResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySingIn", "userAuth", "Ldev/fabula/android/auth/remote/AuthRequest;", "(Ldev/fabula/android/auth/remote/AuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AuthService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "api/v1/sign-in/")
    public abstract java.lang.Object trySingIn(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    dev.fabula.android.auth.remote.AuthRequest userAuth, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.auth.remote.AuthResponse> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "api/v1/contact-wire/")
    public abstract java.lang.Object isValidToken(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.auth.remote.AuthResponse> p0);
}