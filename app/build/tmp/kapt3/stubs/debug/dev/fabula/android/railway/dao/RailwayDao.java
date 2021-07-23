package dev.fabula.android.railway.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\'J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\'\u00a8\u0006\u000b"}, d2 = {"Ldev/fabula/android/railway/dao/RailwayDao;", "", "deleteAll", "", "getRailways", "Lkotlinx/coroutines/flow/Flow;", "", "Ldev/fabula/android/railway/model/Railway;", "insert", "railway", "insertWithReplace", "app_debug"})
public abstract interface RailwayDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM railway")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<dev.fabula.android.railway.model.Railway>> getRailways();
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.railway.model.Railway railway);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertWithReplace(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.railway.model.Railway railway);
    
    @androidx.room.Query(value = "DELETE FROM railway")
    public abstract void deleteAll();
}