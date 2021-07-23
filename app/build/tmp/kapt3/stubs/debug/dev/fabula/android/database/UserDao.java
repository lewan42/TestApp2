package dev.fabula.android.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\'J\b\u0010\u0005\u001a\u00020\u0006H\'J%\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\n\"\u0004\u0018\u00010\u0004H\'\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Ldev/fabula/android/database/UserDao;", "", "all", "", "Ldev/fabula/android/model/User;", "count", "", "insert", "", "users", "", "([Ldev/fabula/android/model/User;)V", "app_debug"})
public abstract interface UserDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM user")
    public abstract java.util.List<dev.fabula.android.model.User> all();
    
    @androidx.room.Query(value = "SELECT COUNT(*) from user")
    public abstract int count();
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.model.User... users);
}