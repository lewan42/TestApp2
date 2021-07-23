package dev.fabula.android.platform.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\'J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\'J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0005H\'J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0012\u001a\u00020\nH\'J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH\'J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\'J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0012\u001a\u00020\nH\'J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000eH\'J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000eH\'J\\\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010!\u001a\u0004\u0018\u00010\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005H\'\u00a8\u0006$"}, d2 = {"Ldev/fabula/android/platform/dao/PlatformDao;", "", "countIsNotSyncEdited", "", "flag_edited", "", "deleteAll", "", "deleteById", "uid", "", "getAllPlatforms", "Lkotlinx/coroutines/flow/Flow;", "", "Ldev/fabula/android/platform/model/Platform;", "getEditedPlatforms", "flag", "getListMeasurementOfPlatform", "uidStationPeregon", "getPlatformById", "uidPlatform", "getPlatformName", "getPlatformsOfStationOrPeregon", "insert", "platform", "insertWithReplace", "update", "numberWay", "kmWay", "picket", "type1", "type2", "photo1", "photo2", "comment", "updateFlagEdited", "app_release"})
public abstract interface PlatformDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM platform")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<dev.fabula.android.platform.model.Platform>> getAllPlatforms();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM platform WHERE station_uid=:uidStationPeregon")
    public abstract java.util.List<dev.fabula.android.platform.model.Platform> getPlatformsOfStationOrPeregon(@org.jetbrains.annotations.NotNull()
    java.lang.String uidStationPeregon);
    
    @androidx.room.Query(value = "UPDATE platform SET flag_edited = :flag WHERE uid =:uid")
    public abstract void updateFlagEdited(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM platform WHERE flag_edited=:flag")
    public abstract java.util.List<dev.fabula.android.platform.model.Platform> getEditedPlatforms(boolean flag);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM platform WHERE station_uid=:uidStationPeregon")
    public abstract java.util.List<dev.fabula.android.platform.model.Platform> getListMeasurementOfPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String uidStationPeregon);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM platform WHERE uid=:uidPlatform")
    public abstract dev.fabula.android.platform.model.Platform getPlatformById(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform);
    
    @androidx.room.Query(value = "SELECT count(uid) FROM platform WHERE flag_edited=:flag_edited")
    public abstract int countIsNotSyncEdited(boolean flag_edited);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.platform.model.Platform platform);
    
    @androidx.room.Query(value = "DELETE FROM platform WHERE uid = :uid")
    public abstract void deleteById(@org.jetbrains.annotations.NotNull()
    java.lang.String uid);
    
    @androidx.room.Query(value = "DELETE FROM platform")
    public abstract void deleteAll();
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertWithReplace(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.platform.model.Platform platform);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT number FROM platform WHERE uid=:uidPlatform")
    public abstract java.lang.String getPlatformName(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform);
    
    @androidx.room.Query(value = "UPDATE platform SET way_number = :numberWay, km_way = :kmWay, picket = :picket,type1=:type1, type2=:type2, photo1=:photo1, photo2=:photo2, comment=:comment,flag_edited=:flag_edited WHERE uid =:uidPlatform")
    public abstract void update(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, @org.jetbrains.annotations.NotNull()
    java.lang.String numberWay, @org.jetbrains.annotations.NotNull()
    java.lang.String kmWay, @org.jetbrains.annotations.NotNull()
    java.lang.String picket, @org.jetbrains.annotations.NotNull()
    java.lang.String type1, @org.jetbrains.annotations.NotNull()
    java.lang.String type2, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2, @org.jetbrains.annotations.NotNull()
    java.lang.String comment, boolean flag_edited);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}