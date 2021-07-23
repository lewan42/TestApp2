package dev.fabula.android.canopy.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\'J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\'J\b\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\'J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0013\u001a\u00020\fH\'J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\fH\'J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\fH\'J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000fH\'J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000fH\'J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\fH\'J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\'J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\'J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\'J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0005H\'J\u001a\u0010!\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\u0005H\'J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0005H\'\u00a8\u0006#"}, d2 = {"Ldev/fabula/android/canopy/dao/CanopyDao;", "", "countIsNotSyncCreated", "", "flag_created", "", "countIsNotSyncEdited", "flag_edited", "deleteAll", "", "deleteById", "uid", "", "getAllCanopies", "", "Ldev/fabula/android/canopy/model/Canopy;", "getCanopiesCreated", "getCanopiesEdited", "getCanopiesOfParent", "uidParent", "getCanopyById", "uidCanopy", "getCanopyOfParent", "insert", "canopy", "insertWithReplace", "isExists", "updateCanopyCenter", "uidMeasurement", "updateCanopyNorth", "updateCanopySouth", "updateFlagCreated", "flag", "updateFlagEditable", "updateFlagEdited", "app_debug"})
public abstract interface CanopyDao {
    
    @androidx.room.Query(value = "DELETE FROM canopy")
    public abstract void deleteAll();
    
    @androidx.room.Query(value = "DELETE FROM canopy WHERE uid = :uid")
    public abstract void deleteById(@org.jetbrains.annotations.NotNull()
    java.lang.String uid);
    
    @androidx.room.Query(value = "UPDATE canopy SET flag_created = :flag WHERE uid =:uid")
    public abstract void updateFlagCreated(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @androidx.room.Query(value = "UPDATE canopy SET flag_edited = :flag WHERE uid =:uid")
    public abstract void updateFlagEdited(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @androidx.room.Query(value = "UPDATE canopy SET flag_edited = :flag WHERE uid =:uid")
    public abstract void updateFlagEditable(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.canopy.model.Canopy canopy);
    
    @androidx.room.Query(value = "SELECT count(uid) FROM canopy WHERE flag_created=:flag_created")
    public abstract int countIsNotSyncCreated(boolean flag_created);
    
    @androidx.room.Query(value = "SELECT count(uid) FROM canopy WHERE flag_edited=:flag_edited")
    public abstract int countIsNotSyncEdited(boolean flag_edited);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertWithReplace(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.canopy.model.Canopy canopy);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM canopy")
    public abstract java.util.List<dev.fabula.android.canopy.model.Canopy> getAllCanopies();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM canopy WHERE flag_created=:flag_created")
    public abstract java.util.List<dev.fabula.android.canopy.model.Canopy> getCanopiesCreated(boolean flag_created);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM canopy WHERE flag_edited=:flag_edited and flag_created is null")
    public abstract java.util.List<dev.fabula.android.canopy.model.Canopy> getCanopiesEdited(boolean flag_edited);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM canopy WHERE platform_uid=:uidParent")
    public abstract java.util.List<dev.fabula.android.canopy.model.Canopy> getCanopiesOfParent(@org.jetbrains.annotations.NotNull()
    java.lang.String uidParent);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM canopy WHERE platform_uid=:uidParent")
    public abstract dev.fabula.android.canopy.model.Canopy getCanopyOfParent(@org.jetbrains.annotations.NotNull()
    java.lang.String uidParent);
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT * FROM canopy WHERE platform_uid=:uidParent)")
    public abstract boolean isExists(@org.jetbrains.annotations.NotNull()
    java.lang.String uidParent);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM canopy WHERE uid=:uidCanopy")
    public abstract dev.fabula.android.canopy.model.Canopy getCanopyById(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy);
    
    @androidx.room.Query(value = "UPDATE canopy SET north_uid = :uidMeasurement WHERE uid =:uidCanopy")
    public abstract void updateCanopyNorth(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy, @org.jetbrains.annotations.NotNull()
    java.lang.String uidMeasurement);
    
    @androidx.room.Query(value = "UPDATE canopy SET center_uid = :uidMeasurement WHERE uid =:uidCanopy")
    public abstract void updateCanopyCenter(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy, @org.jetbrains.annotations.NotNull()
    java.lang.String uidMeasurement);
    
    @androidx.room.Query(value = "UPDATE canopy SET south_uid = :uidMeasurement WHERE uid =:uidCanopy")
    public abstract void updateCanopySouth(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy, @org.jetbrains.annotations.NotNull()
    java.lang.String uidMeasurement);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}