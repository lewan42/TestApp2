package dev.fabula.android.section.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\'J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\'\u00a8\u0006\r"}, d2 = {"Ldev/fabula/android/section/dao/RailwaySectionDao;", "", "deleteAll", "", "getRailwaySections", "Lkotlinx/coroutines/flow/Flow;", "", "Ldev/fabula/android/section/model/RailwaySection;", "uid_railway", "", "insert", "railwaySection", "insertWithReplace", "app_debug"})
public abstract interface RailwaySectionDao {
    
    @androidx.room.Query(value = "DELETE FROM railway_section")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM railway_section WHERE railway_uid=:uid_railway")
    public abstract java.util.List<dev.fabula.android.section.model.RailwaySection> getRailwaySections(@org.jetbrains.annotations.NotNull()
    java.lang.String uid_railway);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM railway_section")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<dev.fabula.android.section.model.RailwaySection>> getRailwaySections();
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.section.model.RailwaySection railwaySection);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertWithReplace(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.section.model.RailwaySection railwaySection);
}