package dev.fabula.android.support.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\'J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\'J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eH\'J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\'J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0012H\'J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0014\u001a\u00020\bH\'J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0006H\'J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0006H\'JX\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\'J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000eH\'J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000eH\'J \u0010$\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\'\u00a8\u0006\'"}, d2 = {"Ldev/fabula/android/support/dao/SupportDao;", "", "deleteAll", "", "getListSupportsByIdAndQuery", "", "Ldev/fabula/android/support/model/Support;", "idParent", "", "filterQuery", "getSupportById", "uid", "getSupportCreated", "flag_created", "", "getSupportEdited", "flag_edited", "getSupports", "Lkotlinx/coroutines/flow/Flow;", "getSupportsOfParent", "uidParent", "insert", "support", "insertWithReplace", "update", "uidSupport", "number", "kmWay", "wayNumber", "picket", "comment", "photo1", "photo2", "updateFlagCreated", "flag", "updateFlagEdited", "updateWires", "uidContactWire", "uidCarrierWire", "app_debug"})
public abstract interface SupportDao {
    
    @androidx.room.Query(value = "DELETE FROM support")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM support")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<dev.fabula.android.support.model.Support>> getSupports();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM support WHERE uid=:uid")
    public abstract dev.fabula.android.support.model.Support getSupportById(@org.jetbrains.annotations.NotNull()
    java.lang.String uid);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM support WHERE flag_created=:flag_created")
    public abstract java.util.List<dev.fabula.android.support.model.Support> getSupportCreated(boolean flag_created);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM support WHERE flag_edited=:flag_edited and flag_created is null")
    public abstract java.util.List<dev.fabula.android.support.model.Support> getSupportEdited(boolean flag_edited);
    
    @androidx.room.Query(value = "UPDATE support SET flag_created = :flag WHERE uid =:uid")
    public abstract void updateFlagCreated(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @androidx.room.Query(value = "UPDATE support SET flag_edited = :flag WHERE uid =:uid")
    public abstract void updateFlagEdited(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.support.model.Support support);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertWithReplace(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.support.model.Support support);
    
    @androidx.room.Query(value = "UPDATE support SET contact_wire = :uidContactWire, carrier_wire = :uidCarrierWire WHERE uid =:uidSupport")
    public abstract void updateWires(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport, @org.jetbrains.annotations.NotNull()
    java.lang.String uidContactWire, @org.jetbrains.annotations.NotNull()
    java.lang.String uidCarrierWire);
    
    @androidx.room.Query(value = "UPDATE support SET number = :number, km_way = :kmWay,way_number = :wayNumber,picket = :picket,comment = :comment,photo1 = :photo1,photo2 = :photo2,flag_edited =:flag_edited WHERE uid =:uidSupport")
    public abstract void update(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport, @org.jetbrains.annotations.NotNull()
    java.lang.String number, @org.jetbrains.annotations.NotNull()
    java.lang.String kmWay, @org.jetbrains.annotations.NotNull()
    java.lang.String wayNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String picket, @org.jetbrains.annotations.Nullable()
    java.lang.String comment, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2, boolean flag_edited);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM support WHERE parent_uid=:idParent and number LIKE \'%\' || :filterQuery || \'%\'")
    public abstract java.util.List<dev.fabula.android.support.model.Support> getListSupportsByIdAndQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String idParent, @org.jetbrains.annotations.NotNull()
    java.lang.String filterQuery);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM support WHERE parent_uid=:uidParent")
    public abstract java.util.List<dev.fabula.android.support.model.Support> getSupportsOfParent(@org.jetbrains.annotations.NotNull()
    java.lang.String uidParent);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}