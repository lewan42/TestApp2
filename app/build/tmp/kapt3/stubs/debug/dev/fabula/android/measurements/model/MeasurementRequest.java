package dev.fabula.android.measurements.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00cf\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\u0002\u0010\u001bJ\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\rH\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u001aH\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\rH\u00c6\u0003J\u00fe\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u00c6\u0001\u00a2\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010P\u001a\u00020\rH\u00d6\u0001J\t\u0010Q\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001dR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001d\u00a8\u0006R"}, d2 = {"Ldev/fabula/android/measurements/model/MeasurementRequest;", "", "uid", "", "value", "ugol_naklona", "vertical_gabarit", "horizontal_gabarit", "km_way", "", "way_number", "picket", "radius", "", "vozvishenie", "comment", "photo1", "photo2", "parent_platform_uid", "parent_gabarit_naves_uid", "parent_gabarit_tor_uid", "parent_main_wire_uid", "parent_contact_wire_uid", "parent_most_perehod_uid", "type_measurement_uid", "created_at", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getComment", "()Ljava/lang/String;", "getCreated_at", "()J", "getHorizontal_gabarit", "getKm_way", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getParent_contact_wire_uid", "getParent_gabarit_naves_uid", "getParent_gabarit_tor_uid", "getParent_main_wire_uid", "getParent_most_perehod_uid", "getParent_platform_uid", "getPhoto1", "getPhoto2", "getPicket", "getRadius", "()I", "getType_measurement_uid", "getUgol_naklona", "getUid", "getValue", "getVertical_gabarit", "getVozvishenie", "getWay_number", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ldev/fabula/android/measurements/model/MeasurementRequest;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class MeasurementRequest {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String uid = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String value = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ugol_naklona = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String vertical_gabarit = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String horizontal_gabarit = null;
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
    private final java.lang.String photo1 = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String photo2 = null;
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
    private final long created_at = 0L;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUgol_naklona() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getVertical_gabarit() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHorizontal_gabarit() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPhoto2() {
        return null;
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
    
    public final long getCreated_at() {
        return 0L;
    }
    
    public MeasurementRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    java.lang.String ugol_naklona, @org.jetbrains.annotations.Nullable()
    java.lang.String vertical_gabarit, @org.jetbrains.annotations.Nullable()
    java.lang.String horizontal_gabarit, @org.jetbrains.annotations.Nullable()
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
    java.lang.String type_measurement_uid, long created_at) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int component10() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
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
    
    public final long component21() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.fabula.android.measurements.model.MeasurementRequest copy(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    java.lang.String ugol_naklona, @org.jetbrains.annotations.Nullable()
    java.lang.String vertical_gabarit, @org.jetbrains.annotations.Nullable()
    java.lang.String horizontal_gabarit, @org.jetbrains.annotations.Nullable()
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
    java.lang.String type_measurement_uid, long created_at) {
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