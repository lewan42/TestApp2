package dev.fabula.android.bridge.crossing.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\n\u001a\u00020\bH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\fH\'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0006H\'J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0006H\'J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\bH\'J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\bH\'\u00a8\u0006\u0017"}, d2 = {"Ldev/fabula/android/bridge/crossing/dao/BridgeCrossingDao;", "", "deleteAll", "", "getBridgeCreated", "", "Ldev/fabula/android/bridge/crossing/model/BridgeCrossing;", "flag_created", "", "getBridgeEdited", "flag_edited", "getBridgeName", "", "uidBridge", "getBridgesCrossing", "uidParent", "insert", "bridgeCrossing", "insertWithReplace", "updateFlagCreated", "uid", "flag", "updateFlagEdited", "app_release"})
public abstract interface BridgeCrossingDao {
    
    @androidx.room.Query(value = "DELETE FROM bridge")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM bridge WHERE platform_uid=:uidParent")
    public abstract java.util.List<dev.fabula.android.bridge.crossing.model.BridgeCrossing> getBridgesCrossing(@org.jetbrains.annotations.NotNull()
    java.lang.String uidParent);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT name FROM bridge WHERE uid=:uidBridge")
    public abstract java.lang.String getBridgeName(@org.jetbrains.annotations.NotNull()
    java.lang.String uidBridge);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM bridge WHERE flag_created=:flag_created")
    public abstract java.util.List<dev.fabula.android.bridge.crossing.model.BridgeCrossing> getBridgeCreated(boolean flag_created);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM bridge WHERE flag_edited=:flag_edited and flag_created is null")
    public abstract java.util.List<dev.fabula.android.bridge.crossing.model.BridgeCrossing> getBridgeEdited(boolean flag_edited);
    
    @androidx.room.Query(value = "UPDATE bridge SET flag_created = :flag WHERE uid =:uid")
    public abstract void updateFlagCreated(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @androidx.room.Query(value = "UPDATE bridge SET flag_edited = :flag WHERE uid =:uid")
    public abstract void updateFlagEdited(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.bridge.crossing.model.BridgeCrossing bridgeCrossing);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertWithReplace(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.bridge.crossing.model.BridgeCrossing bridgeCrossing);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}