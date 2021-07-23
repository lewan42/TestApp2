package dev.fabula.android.measurements.type.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\tH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H\'\u00a8\u0006\u000e"}, d2 = {"Ldev/fabula/android/measurements/type/dao/MeasurementTypeDao;", "", "deleteAll", "", "getTypeMeasurementByType", "Ldev/fabula/android/measurements/type/model/MeasurementType;", "type", "", "getTypeMeasurements", "Lkotlinx/coroutines/flow/Flow;", "", "insert", "measurementType", "insertWithReplace", "app_release"})
public abstract interface MeasurementTypeDao {
    
    @androidx.room.Query(value = "DELETE FROM type_measurement")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM type_measurement")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<dev.fabula.android.measurements.type.model.MeasurementType>> getTypeMeasurements();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM type_measurement WHERE type_of=:type")
    public abstract dev.fabula.android.measurements.type.model.MeasurementType getTypeMeasurementByType(@org.jetbrains.annotations.NotNull()
    java.lang.String type);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.type.model.MeasurementType measurementType);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertWithReplace(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.type.model.MeasurementType measurementType);
}