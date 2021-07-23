package dev.fabula.android.measurements.model;

import java.lang.System;

@androidx.room.Entity(tableName = "measurement")
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\bD\b\u0087\b\u0018\u00002\u00020\u0001B\u00f3\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\u0002\u0010 J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u000fH\u00c6\u0003J\t\u0010G\u001a\u00020\u000fH\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u001cH\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010T\u001a\u0004\u0018\u00010\u001cH\u00c6\u0003\u00a2\u0006\u0002\u0010&J\t\u0010U\u001a\u00020\u001fH\u00c6\u0003J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\t\u0010W\u001a\u00020\u0003H\u00c6\u0003J\t\u0010X\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010,J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00aa\u0002\u0010]\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u00c6\u0001\u00a2\u0006\u0002\u0010^J\u0013\u0010_\u001a\u00020\u001c2\b\u0010`\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010a\u001a\u00020\u000fH\u00d6\u0001J\t\u0010b\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b%\u0010&R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b(\u0010&R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\"\"\u0004\b7\u00108R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\"\"\u0004\b:\u00108R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\"R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010\"R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010\"R\u0011\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010=R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010\"\u00a8\u0006c"}, d2 = {"Ldev/fabula/android/measurements/model/Measurement;", "", "uid", "", "gipotinuza", "ugol_naklona", "vertical_gabarit", "horizontal_gabarit", "lat", "lng", "km_way", "", "way_number", "picket", "radius", "", "vozvishenie", "comment", "photo1", "photo2", "parent_platform_uid", "parent_gabarit_naves_uid", "parent_gabarit_tor_uid", "parent_main_wire_uid", "parent_contact_wire_uid", "parent_most_perehod_uid", "type_measurement_uid", "flag_created", "", "flag_edited", "created_at", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;J)V", "getComment", "()Ljava/lang/String;", "getCreated_at", "()J", "getFlag_created", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFlag_edited", "getGipotinuza", "getHorizontal_gabarit", "getKm_way", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLat", "getLng", "getParent_contact_wire_uid", "getParent_gabarit_naves_uid", "getParent_gabarit_tor_uid", "getParent_main_wire_uid", "getParent_most_perehod_uid", "getParent_platform_uid", "getPhoto1", "setPhoto1", "(Ljava/lang/String;)V", "getPhoto2", "setPhoto2", "getPicket", "getRadius", "()I", "getType_measurement_uid", "getUgol_naklona", "getUid", "getVertical_gabarit", "getVozvishenie", "getWay_number", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;J)Ldev/fabula/android/measurements/model/Measurement;", "equals", "other", "hashCode", "toString", "app_release"})
public final class Measurement {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey(autoGenerate = false)
    private final java.lang.String uid = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "value")
    private final java.lang.String gipotinuza = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ugol_naklona = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String vertical_gabarit = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String horizontal_gabarit = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String lat = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "long")
    private final java.lang.String lng = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double km_way = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String way_number = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String picket = null;
    private final int radius = 0;
    private final int vozvishenie = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String comment = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String photo1;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String photo2;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String parent_platform_uid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String parent_gabarit_naves_uid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String parent_gabarit_tor_uid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String parent_main_wire_uid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String parent_contact_wire_uid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String parent_most_perehod_uid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String type_measurement_uid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean flag_created = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean flag_edited = null;
    private final long created_at = 0L;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGipotinuza() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUgol_naklona() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVertical_gabarit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHorizontal_gabarit() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLat() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLng() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getKm_way() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWay_number() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPicket() {
        return null;
    }
    
    public final int getRadius() {
        return 0;
    }
    
    public final int getVozvishenie() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getComment() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPhoto1() {
        return null;
    }
    
    public final void setPhoto1(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPhoto2() {
        return null;
    }
    
    public final void setPhoto2(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParent_platform_uid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParent_gabarit_naves_uid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParent_gabarit_tor_uid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParent_main_wire_uid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParent_contact_wire_uid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParent_most_perehod_uid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getType_measurement_uid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getFlag_created() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getFlag_edited() {
        return null;
    }
    
    public final long getCreated_at() {
        return 0L;
    }
    
    public Measurement(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String gipotinuza, @org.jetbrains.annotations.NotNull()
    java.lang.String ugol_naklona, @org.jetbrains.annotations.NotNull()
    java.lang.String vertical_gabarit, @org.jetbrains.annotations.NotNull()
    java.lang.String horizontal_gabarit, @org.jetbrains.annotations.Nullable()
    java.lang.String lat, @org.jetbrains.annotations.Nullable()
    java.lang.String lng, @org.jetbrains.annotations.Nullable()
    java.lang.Double km_way, @org.jetbrains.annotations.Nullable()
    java.lang.String way_number, @org.jetbrains.annotations.Nullable()
    java.lang.String picket, int radius, int vozvishenie, @org.jetbrains.annotations.Nullable()
    java.lang.String comment, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2, @org.jetbrains.annotations.Nullable()
    java.lang.String parent_platform_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String parent_gabarit_naves_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String parent_gabarit_tor_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String parent_main_wire_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String parent_contact_wire_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String parent_most_perehod_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String type_measurement_uid, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean flag_created, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean flag_edited, long created_at) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int component12() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component24() {
        return null;
    }
    
    public final long component25() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.fabula.android.measurements.model.Measurement copy(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String gipotinuza, @org.jetbrains.annotations.NotNull()
    java.lang.String ugol_naklona, @org.jetbrains.annotations.NotNull()
    java.lang.String vertical_gabarit, @org.jetbrains.annotations.NotNull()
    java.lang.String horizontal_gabarit, @org.jetbrains.annotations.Nullable()
    java.lang.String lat, @org.jetbrains.annotations.Nullable()
    java.lang.String lng, @org.jetbrains.annotations.Nullable()
    java.lang.Double km_way, @org.jetbrains.annotations.Nullable()
    java.lang.String way_number, @org.jetbrains.annotations.Nullable()
    java.lang.String picket, int radius, int vozvishenie, @org.jetbrains.annotations.Nullable()
    java.lang.String comment, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2, @org.jetbrains.annotations.Nullable()
    java.lang.String parent_platform_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String parent_gabarit_naves_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String parent_gabarit_tor_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String parent_main_wire_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String parent_contact_wire_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String parent_most_perehod_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String type_measurement_uid, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean flag_created, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean flag_edited, long created_at) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}