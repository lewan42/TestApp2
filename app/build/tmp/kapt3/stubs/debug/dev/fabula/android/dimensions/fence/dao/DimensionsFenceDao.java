package dev.fabula.android.dimensions.fence.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\'J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\'J\b\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\fH\'J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\'J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\fH\'J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0011H\'J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0005H\'J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0005H\'J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\'\u00a8\u0006\u001c"}, d2 = {"Ldev/fabula/android/dimensions/fence/dao/DimensionsFenceDao;", "", "countIsNotSyncCreated", "", "flag_created", "", "countIsNotSyncEdited", "flag_edited", "deleteAll", "", "deleteById", "uid", "", "getCountDimensionsOfPlatform", "uidParent", "getDimensionsCreated", "", "Ldev/fabula/android/dimensions/fence/model/DimensionsFence;", "getDimensionsEdited", "getDimensionsFenceOfPlatform", "uidPlatform", "insertWithReplace", "dimensionsFence", "updateFlagCreated", "flag", "updateFlagEdited", "updateMeasurementOfDimension", "direction", "app_debug"})
public abstract interface DimensionsFenceDao {
    
    @androidx.room.Query(value = "DELETE FROM gabarittor")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM gabarittor WHERE flag_created=:flag_created")
    public abstract java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsFence> getDimensionsCreated(boolean flag_created);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM gabarittor WHERE flag_edited=:flag_edited and flag_created is null")
    public abstract java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsFence> getDimensionsEdited(boolean flag_edited);
    
    @androidx.room.Query(value = "SELECT count(uid) FROM gabarittor WHERE flag_created=:flag_created")
    public abstract int countIsNotSyncCreated(boolean flag_created);
    
    @androidx.room.Query(value = "SELECT count(uid) FROM gabarittor WHERE flag_edited=:flag_edited")
    public abstract int countIsNotSyncEdited(boolean flag_edited);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM gabarittor WHERE platform_uid=:uidPlatform")
    public abstract java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsFence> getDimensionsFenceOfPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform);
    
    @androidx.room.Query(value = "UPDATE gabarittor SET direction = :direction WHERE uid =:uid")
    public abstract void updateMeasurementOfDimension(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String direction);
    
    @androidx.room.Query(value = "SELECT count(uid) FROM gabarittor WHERE platform_uid=:uidParent")
    public abstract int getCountDimensionsOfPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String uidParent);
    
    @androidx.room.Query(value = "DELETE FROM gabarittor WHERE uid = :uid")
    public abstract void deleteById(@org.jetbrains.annotations.NotNull()
    java.lang.String uid);
    
    @androidx.room.Query(value = "UPDATE gabarittor SET flag_created = :flag WHERE uid =:uid")
    public abstract void updateFlagCreated(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @androidx.room.Query(value = "UPDATE gabarittor SET flag_edited = :flag WHERE uid =:uid")
    public abstract void updateFlagEdited(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertWithReplace(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.dimensions.fence.model.DimensionsFence dimensionsFence);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}