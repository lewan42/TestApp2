package dev.fabula.android.app.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Ldev/fabula/android/app/data/remote/RemoteServiceException;", "Ljava/lang/RuntimeException;", "error", "Ldev/fabula/android/app/data/remote/Response$Error;", "(Ldev/fabula/android/app/data/remote/Response$Error;)V", "getError", "()Ldev/fabula/android/app/data/remote/Response$Error;", "app_debug"})
public final class RemoteServiceException extends java.lang.RuntimeException {
    @org.jetbrains.annotations.NotNull()
    private final dev.fabula.android.app.data.remote.Response.Error error = null;
    
    @org.jetbrains.annotations.NotNull()
    public final dev.fabula.android.app.data.remote.Response.Error getError() {
        return null;
    }
    
    public RemoteServiceException(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.app.data.remote.Response.Error error) {
        super();
    }
}