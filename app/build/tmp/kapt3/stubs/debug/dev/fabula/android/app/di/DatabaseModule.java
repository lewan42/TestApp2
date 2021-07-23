package dev.fabula.android.app.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Ldev/fabula/android/app/di/DatabaseModule;", "", "()V", "appDatabase", "Ldev/fabula/android/app/db/AppRoomDatabase;", "getAppDatabase", "()Ldev/fabula/android/app/db/AppRoomDatabase;", "setAppDatabase", "(Ldev/fabula/android/app/db/AppRoomDatabase;)V", "databaseCallback", "Landroidx/room/RoomDatabase$Callback;", "providesRoomDatabase", "context", "Landroid/content/Context;", "app_debug"})
@dagger.Module()
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public dev.fabula.android.app.db.AppRoomDatabase appDatabase;
    private final androidx.room.RoomDatabase.Callback databaseCallback = null;
    
    @org.jetbrains.annotations.NotNull()
    public final dev.fabula.android.app.db.AppRoomDatabase getAppDatabase() {
        return null;
    }
    
    public final void setAppDatabase(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.app.db.AppRoomDatabase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final dev.fabula.android.app.db.AppRoomDatabase providesRoomDatabase(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public DatabaseModule() {
        super();
    }
}