package dev.fabula.android.station.peregon.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\'J \u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\'J&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\'J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0012H\'J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0006H\'J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\'J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH\'J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH\'J6\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u000bH\'J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\'\u00a8\u0006 "}, d2 = {"Ldev/fabula/android/station/peregon/dao/StationPeregonDao;", "", "deleteAll", "", "deleteById", "uid", "", "getEditedStations", "", "Ldev/fabula/android/station/peregon/model/StationPeregon;", "flag", "", "getListStationOrPeregonByIdAndType", "idRailwaySection", "type", "getListStationOrPeregonByIdAndTypeAndQuery", "query", "getStationPeregons", "Lkotlinx/coroutines/flow/Flow;", "getStationPeregonsById", "id", "getStationPeregonsByIdAndQuery", "insert", "stationPeregon", "insertWithReplace", "update", "uidStation", "comment", "photo1", "photo2", "flag_edited", "updateFlagEdited", "app_debug"})
public abstract interface StationPeregonDao {
    
    @androidx.room.Query(value = "DELETE FROM station_peregon")
    public abstract void deleteAll();
    
    @androidx.room.Query(value = "DELETE FROM station_peregon WHERE uid = :uid")
    public abstract void deleteById(@org.jetbrains.annotations.NotNull()
    java.lang.String uid);
    
    @androidx.room.Query(value = "UPDATE station_peregon SET flag_edited = :flag WHERE uid =:uid")
    public abstract void updateFlagEdited(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, boolean flag);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM station_peregon")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<dev.fabula.android.station.peregon.model.StationPeregon>> getStationPeregons();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM station_peregon WHERE flag_edited=:flag")
    public abstract java.util.List<dev.fabula.android.station.peregon.model.StationPeregon> getEditedStations(boolean flag);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM station_peregon WHERE uid=:id")
    public abstract dev.fabula.android.station.peregon.model.StationPeregon getStationPeregonsById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM station_peregon WHERE railway_sector_uid=:idRailwaySection and name LIKE \'%\' || :query || \'%\'")
    public abstract java.util.List<dev.fabula.android.station.peregon.model.StationPeregon> getStationPeregonsByIdAndQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String idRailwaySection, @org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM station_peregon WHERE railway_sector_uid=:idRailwaySection and type_of=:type")
    public abstract java.util.List<dev.fabula.android.station.peregon.model.StationPeregon> getListStationOrPeregonByIdAndType(@org.jetbrains.annotations.NotNull()
    java.lang.String idRailwaySection, @org.jetbrains.annotations.Nullable()
    java.lang.String type);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM station_peregon WHERE railway_sector_uid=:idRailwaySection and type_of=:type and name LIKE \'%\' || :query || \'%\'")
    public abstract java.util.List<dev.fabula.android.station.peregon.model.StationPeregon> getListStationOrPeregonByIdAndTypeAndQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String idRailwaySection, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.station.peregon.model.StationPeregon stationPeregon);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertWithReplace(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.station.peregon.model.StationPeregon stationPeregon);
    
    @androidx.room.Query(value = "UPDATE station_peregon SET comment = :comment, photo1 = :photo1, photo2 = :photo2, flag_edited=:flag_edited  WHERE uid =:uidStation")
    public abstract void update(@org.jetbrains.annotations.NotNull()
    java.lang.String uidStation, @org.jetbrains.annotations.NotNull()
    java.lang.String comment, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2, boolean flag_edited);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}