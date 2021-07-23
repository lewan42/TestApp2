package dev.fabula.android.app.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\rB\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00028\u00008F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0002X\u0083\u0004\u00a2\u0006\u0004\n\u0002\u0010\f\u00a8\u0006\u000e"}, d2 = {"Ldev/fabula/android/app/data/remote/Response;", "R", "", "result", "error", "Ldev/fabula/android/app/data/remote/Response$Error;", "(Ljava/lang/Object;Ldev/fabula/android/app/data/remote/Response$Error;)V", "data", "getData", "()Ljava/lang/Object;", "getError", "()Ldev/fabula/android/app/data/remote/Response$Error;", "Ljava/lang/Object;", "Error", "app_debug"})
public final class Response<R extends java.lang.Object> {
    @com.google.gson.annotations.SerializedName(value = "result")
    private final R result = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "error")
    private final dev.fabula.android.app.data.remote.Response.Error error = null;
    
    public final R getData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final dev.fabula.android.app.data.remote.Response.Error getError() {
        return null;
    }
    
    public Response(@org.jetbrains.annotations.Nullable()
    R result, @org.jetbrains.annotations.Nullable()
    dev.fabula.android.app.data.remote.Response.Error error) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Ldev/fabula/android/app/data/remote/Response$Error;", "", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "app_debug"})
    public static final class Error {
        @com.google.gson.annotations.SerializedName(value = "code")
        private final int code = 0;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "message")
        private final java.lang.String message = null;
        
        public final int getCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
        
        public Error(int code, @org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            super();
        }
    }
}