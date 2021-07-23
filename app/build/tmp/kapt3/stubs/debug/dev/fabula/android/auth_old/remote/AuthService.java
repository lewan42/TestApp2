package dev.fabula.android.auth_old.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0016\b\u0001\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ/\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0016\b\u0001\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Ldev/fabula/android/auth_old/remote/AuthService;", "", "validateCode", "Ldev/fabula/android/app/data/remote/Response;", "Ldev/fabula/android/auth_old/remote/AuthResponse;", "data", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validatePhone", "Ldev/fabula/android/auth_old/remote/CodeResponse;", "app_debug"})
public abstract interface AuthService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "phone-validate")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object validatePhone(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.app.data.remote.Response<dev.fabula.android.auth_old.remote.CodeResponse>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "validate-code")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object validateCode(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.fabula.android.app.data.remote.Response<dev.fabula.android.auth_old.remote.AuthResponse>> p1);
}