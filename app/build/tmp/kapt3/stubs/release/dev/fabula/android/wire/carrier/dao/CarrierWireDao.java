package dev.fabula.android.wire.carrier.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\nH\'J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\rH\'J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\rH\'J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0005H\'\u00a8\u0006\u0016"}, d2 = {"Ldev/fabula/android/wire/carrier/dao/CarrierWireDao;", "", "countIsNotSync", "", "flag_created", "", "deleteAll", "", "deleteById", "uid", "", "getCarrierWireCreated", "", "Ldev/fabula/android/wire/carrier/model/CarrierWire;", "getCarrierWireOfSupport", "uidParent", "getCountCarrierWireOfSupport", "insert", "carrierWire", "insertWithReplace", "updateFlagCreated", "flag", "app_release"})
public abstract interface CarrierWireDao {
    
    @androidx.room.Query(value = "DELETE FROM carrier_wire")
    public abstract void deleteAll();
    
    @androidx.room.Query(value = "DELETE FROM carrier_wire WHERE uid = :uid")
    public abstract void deleteById(@org.jetbrains.annotations.NotNull()
    java.lang.String uid);
    
    @androidx.room.Query(value = "UPDATE carrier_wire SET flag_created = :flag WHERE uid =:uid")
    public abstract void updateFlagCreated(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @androidx.room.Query(value = "SELECT count(uid) FROM carrier_wire WHERE opora_uid=:uidParent")
    public abstract int getCountCarrierWireOfSupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidParent);
    
    @androidx.room.Query(value = "SELECT count(uid) FROM carrier_wire WHERE flag_created=:flag_created")
    public abstract int countIsNotSync(boolean flag_created);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM carrier_wire WHERE opora_uid=:uidParent")
    public abstract dev.fabula.android.wire.carrier.model.CarrierWire getCarrierWireOfSupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidParent);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM carrier_wire WHERE flag_created=:flag_created")
    public abstract java.util.List<dev.fabula.android.wire.carrier.model.CarrierWire> getCarrierWireCreated(boolean flag_created);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.wire.carrier.model.CarrierWire carrierWire);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertWithReplace(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.wire.carrier.model.CarrierWire carrierWire);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}