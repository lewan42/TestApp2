package dev.fabula.android.measurements.create.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b)\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\'J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\'J\b\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\'J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0003H\'J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0003H\'J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0003H\'J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\fH\'J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\'J\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\'J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\fH\'J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\fH\'J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\'J\u001a\u0010 \u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\'J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0015\u001a\u00020\fH\'J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u000fH\'J\u0016\u0010$\u001a\u00020\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\'J\u0018\u0010&\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\'\u001a\u00020\u0005H\'J\u0018\u0010(\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\'\u001a\u00020\u0005H\'J*\u0010)\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\'JP\u0010)\u001a\u00020\t2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\fH\u0017J*\u00105\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\'J\u0018\u00106\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00107\u001a\u00020\fH\'\u00a8\u00068"}, d2 = {"Ldev/fabula/android/measurements/create/dao/CreateMeasurementsDao;", "", "countIsNotSyncCreated", "", "flag_created", "", "countIsNotSyncEdited", "flag_edited", "deleteAll", "", "deleteById", "uid", "", "getCountLastMeasurementsOfBridge", "", "Ldev/fabula/android/measurements/model/Measurement;", "uidBridge", "count", "getCountLastMeasurementsOfCanopy", "uidCanopy", "getCountLastMeasurementsOfPlatform", "uidPlatform", "getMeasurementById", "getMeasurementOfDimensionsFence", "uidDimension", "getMeasurements", "getMeasurementsCreated", "getMeasurementsEdited", "getMeasurementsOfBridge", "getMeasurementsOfCanopy", "getMeasurementsOfCarrierWire", "uidType", "getMeasurementsOfContactWire", "getMeasurementsOfPlatform", "insert", "measurement", "insertAll", "measurements", "updateFlagCreated", "flag", "updateFlagEdited", "updateMeasurementOfCanopy", "v", "h", "uid1", "v1", "h1", "uid2", "v2", "h2", "uid3", "v3", "h3", "updateMeasurementOfDimension", "updatePhotoZamer", "photo1", "app_release"})
public abstract interface CreateMeasurementsDao {
    
    @androidx.room.Query(value = "DELETE FROM measurement")
    public abstract void deleteAll();
    
    @androidx.room.Query(value = "DELETE FROM measurement WHERE uid = :uid")
    public abstract void deleteById(@org.jetbrains.annotations.NotNull()
    java.lang.String uid);
    
    @androidx.room.Query(value = "UPDATE measurement SET flag_created = :flag WHERE uid =:uid")
    public abstract void updateFlagCreated(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @androidx.room.Query(value = "UPDATE measurement SET photo1 = :photo1 WHERE uid =:uid")
    public abstract void updatePhotoZamer(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String photo1);
    
    @androidx.room.Query(value = "UPDATE measurement SET flag_edited = :flag WHERE uid =:uid")
    public abstract void updateFlagEdited(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @androidx.room.Query(value = "SELECT count(uid) FROM measurement WHERE flag_created=:flag_created")
    public abstract int countIsNotSyncCreated(boolean flag_created);
    
    @androidx.room.Query(value = "SELECT count(uid) FROM measurement WHERE flag_edited=:flag_edited")
    public abstract int countIsNotSyncEdited(boolean flag_edited);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM measurement")
    public abstract java.util.List<dev.fabula.android.measurements.model.Measurement> getMeasurements();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM measurement WHERE parent_platform_uid=:uidPlatform")
    public abstract java.util.List<dev.fabula.android.measurements.model.Measurement> getMeasurementsOfPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from (select distinct DATE(created_at, \'unixepoch\') as date from measurement WHERE parent_platform_uid=:uidPlatform order by date desc limit :count) sub join measurement m on sub.date = DATE(m.created_at, \'unixepoch\')")
    public abstract java.util.List<dev.fabula.android.measurements.model.Measurement> getCountLastMeasurementsOfPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, int count);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from (select distinct DATE(created_at, \'unixepoch\') as date from measurement WHERE parent_most_perehod_uid=:uidBridge order by date desc limit :count) sub join measurement m on sub.date = DATE(m.created_at, \'unixepoch\')")
    public abstract java.util.List<dev.fabula.android.measurements.model.Measurement> getCountLastMeasurementsOfBridge(@org.jetbrains.annotations.NotNull()
    java.lang.String uidBridge, int count);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from (select distinct DATE(created_at, \'unixepoch\') as date from measurement WHERE parent_gabarit_naves_uid=:uidCanopy order by date desc limit :count) sub join measurement m on sub.date = DATE(m.created_at, \'unixepoch\')")
    public abstract java.util.List<dev.fabula.android.measurements.model.Measurement> getCountLastMeasurementsOfCanopy(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy, int count);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM measurement WHERE parent_most_perehod_uid=:uidBridge")
    public abstract java.util.List<dev.fabula.android.measurements.model.Measurement> getMeasurementsOfBridge(@org.jetbrains.annotations.NotNull()
    java.lang.String uidBridge);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM measurement WHERE uid=:uid")
    public abstract dev.fabula.android.measurements.model.Measurement getMeasurementById(@org.jetbrains.annotations.NotNull()
    java.lang.String uid);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM measurement WHERE parent_gabarit_tor_uid=:uidDimension")
    public abstract dev.fabula.android.measurements.model.Measurement getMeasurementOfDimensionsFence(@org.jetbrains.annotations.NotNull()
    java.lang.String uidDimension);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM measurement WHERE parent_gabarit_naves_uid=:uid")
    public abstract java.util.List<dev.fabula.android.measurements.model.Measurement> getMeasurementsOfCanopy(@org.jetbrains.annotations.NotNull()
    java.lang.String uid);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM measurement WHERE type_measurement_uid=:uidType AND parent_contact_wire_uid=:uid")
    public abstract dev.fabula.android.measurements.model.Measurement getMeasurementsOfContactWire(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String uidType);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM measurement WHERE type_measurement_uid=:uidType AND parent_main_wire_uid=:uid")
    public abstract dev.fabula.android.measurements.model.Measurement getMeasurementsOfCarrierWire(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String uidType);
    
    @androidx.room.Query(value = "UPDATE measurement SET vertical_gabarit = :v,horizontal_gabarit = :h ,flag_edited = :flag_edited  WHERE uid =:uid")
    public abstract void updateMeasurementOfCanopy(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String v, @org.jetbrains.annotations.NotNull()
    java.lang.String h, boolean flag_edited);
    
    @androidx.room.Query(value = "UPDATE measurement SET vertical_gabarit = :v,horizontal_gabarit = :h,flag_edited = :flag_edited  WHERE parent_gabarit_tor_uid =:uid")
    public abstract void updateMeasurementOfDimension(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String v, @org.jetbrains.annotations.NotNull()
    java.lang.String h, boolean flag_edited);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM measurement WHERE flag_created=:flag_created")
    public abstract java.util.List<dev.fabula.android.measurements.model.Measurement> getMeasurementsCreated(boolean flag_created);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM measurement WHERE flag_edited=:flag_edited and flag_created is null")
    public abstract java.util.List<dev.fabula.android.measurements.model.Measurement> getMeasurementsEdited(boolean flag_edited);
    
    @androidx.room.Transaction()
    public abstract void updateMeasurementOfCanopy(@org.jetbrains.annotations.NotNull()
    java.lang.String uid1, @org.jetbrains.annotations.NotNull()
    java.lang.String v1, @org.jetbrains.annotations.NotNull()
    java.lang.String h1, @org.jetbrains.annotations.NotNull()
    java.lang.String uid2, @org.jetbrains.annotations.NotNull()
    java.lang.String v2, @org.jetbrains.annotations.NotNull()
    java.lang.String h2, @org.jetbrains.annotations.NotNull()
    java.lang.String uid3, @org.jetbrains.annotations.NotNull()
    java.lang.String v3, @org.jetbrains.annotations.NotNull()
    java.lang.String h3);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.model.Measurement measurement);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.measurements.model.Measurement> measurements);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @androidx.room.Transaction()
        public static void updateMeasurementOfCanopy(@org.jetbrains.annotations.NotNull()
        dev.fabula.android.measurements.create.dao.CreateMeasurementsDao $this, @org.jetbrains.annotations.NotNull()
        java.lang.String uid1, @org.jetbrains.annotations.NotNull()
        java.lang.String v1, @org.jetbrains.annotations.NotNull()
        java.lang.String h1, @org.jetbrains.annotations.NotNull()
        java.lang.String uid2, @org.jetbrains.annotations.NotNull()
        java.lang.String v2, @org.jetbrains.annotations.NotNull()
        java.lang.String h2, @org.jetbrains.annotations.NotNull()
        java.lang.String uid3, @org.jetbrains.annotations.NotNull()
        java.lang.String v3, @org.jetbrains.annotations.NotNull()
        java.lang.String h3) {
        }
    }
}