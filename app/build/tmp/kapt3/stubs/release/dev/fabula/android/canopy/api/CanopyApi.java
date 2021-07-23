package dev.fabula.android.canopy.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Ldev/fabula/android/canopy/api/CanopyApi;", "", "create", "Lretrofit2/Response;", "Ldev/fabula/android/canopy/model/CanopyResponse;", "canopy", "Ldev/fabula/android/canopy/model/CanopyRequest;", "(Ldev/fabula/android/canopy/model/CanopyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "uid", "", "(Ljava/lang/String;Ldev/fabula/android/canopy/model/CanopyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface CanopyApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "api/v1/gabarit-naves/")
    public abstract java.lang.Object create(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    dev.fabula.android.canopy.model.CanopyRequest canopy, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<dev.fabula.android.canopy.model.CanopyResponse>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.PATCH(value = "api/v1/gabarit-naves/{uid}/")
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "uid")
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    dev.fabula.android.canopy.model.CanopyRequest canopy, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<dev.fabula.android.canopy.model.CanopyResponse>> p2);
}