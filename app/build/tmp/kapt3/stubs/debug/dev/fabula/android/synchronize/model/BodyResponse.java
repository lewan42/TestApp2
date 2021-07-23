package dev.fabula.android.synchronize.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003\u00a2\u0006\u0002\u0010\u001bJ\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003H\u00c6\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003H\u00c6\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003H\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\u00c6\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H\u00c6\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\u00c6\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003H\u00c6\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003H\u00c6\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003H\u00c6\u0003J\u00c9\u0001\u00105\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003H\u00c6\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00109\u001a\u00020:H\u00d6\u0001J\t\u0010;\u001a\u00020<H\u00d6\u0001R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001dR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001d\u00a8\u0006="}, d2 = {"Ldev/fabula/android/synchronize/model/BodyResponse;", "", "measurementType", "", "Ldev/fabula/android/measurements/type/model/MeasurementType;", "measurement", "Ldev/fabula/android/measurements/model/Measurement;", "railway", "Ldev/fabula/android/railway/model/Railway;", "railwaysector", "Ldev/fabula/android/section/model/RailwaySection;", "station", "Ldev/fabula/android/station/peregon/model/StationPeregon;", "platforms", "Ldev/fabula/android/platform/model/Platform;", "supports", "Ldev/fabula/android/support/model/Support;", "bridges", "Ldev/fabula/android/bridge/crossing/model/BridgeCrossing;", "contactWire", "Ldev/fabula/android/wire/contact/model/ContactWire;", "carrierWire", "Ldev/fabula/android/wire/carrier/model/CarrierWire;", "gabaritnaves", "Ldev/fabula/android/canopy/model/Canopy;", "gabarittor", "Ldev/fabula/android/dimensions/fence/model/DimensionsFence;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBridges", "()Ljava/util/List;", "getCarrierWire", "getContactWire", "getGabaritnaves", "getGabarittor", "getMeasurement", "getMeasurementType", "getPlatforms", "getRailway", "getRailwaysector", "getStation", "getSupports", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class BodyResponse {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "measurementtype")
    private final java.util.List<dev.fabula.android.measurements.type.model.MeasurementType> measurementType = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "measurement")
    private final java.util.List<dev.fabula.android.measurements.model.Measurement> measurement = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "railway")
    private final java.util.List<dev.fabula.android.railway.model.Railway> railway = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "railwaysector")
    private final java.util.List<dev.fabula.android.section.model.RailwaySection> railwaysector = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "station")
    private final java.util.List<dev.fabula.android.station.peregon.model.StationPeregon> station = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "platform")
    private final java.util.List<dev.fabula.android.platform.model.Platform> platforms = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "opora")
    private final java.util.List<dev.fabula.android.support.model.Support> supports = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "bridge")
    private final java.util.List<dev.fabula.android.bridge.crossing.model.BridgeCrossing> bridges = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "contactwire")
    private final java.util.List<dev.fabula.android.wire.contact.model.ContactWire> contactWire = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "mainwire")
    private final java.util.List<dev.fabula.android.wire.carrier.model.CarrierWire> carrierWire = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "gabaritnaves")
    private final java.util.List<dev.fabula.android.canopy.model.Canopy> gabaritnaves = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "gabarittor")
    private final java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsFence> gabarittor = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.measurements.type.model.MeasurementType> getMeasurementType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.measurements.model.Measurement> getMeasurement() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.railway.model.Railway> getRailway() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.section.model.RailwaySection> getRailwaysector() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.station.peregon.model.StationPeregon> getStation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.platform.model.Platform> getPlatforms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.support.model.Support> getSupports() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.bridge.crossing.model.BridgeCrossing> getBridges() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.wire.contact.model.ContactWire> getContactWire() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.wire.carrier.model.CarrierWire> getCarrierWire() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.canopy.model.Canopy> getGabaritnaves() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsFence> getGabarittor() {
        return null;
    }
    
    public BodyResponse(@org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.measurements.type.model.MeasurementType> measurementType, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.measurements.model.Measurement> measurement, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.railway.model.Railway> railway, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.section.model.RailwaySection> railwaysector, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.station.peregon.model.StationPeregon> station, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.platform.model.Platform> platforms, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.support.model.Support> supports, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.bridge.crossing.model.BridgeCrossing> bridges, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.wire.contact.model.ContactWire> contactWire, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.wire.carrier.model.CarrierWire> carrierWire, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.canopy.model.Canopy> gabaritnaves, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsFence> gabarittor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.measurements.type.model.MeasurementType> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.measurements.model.Measurement> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.railway.model.Railway> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.section.model.RailwaySection> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.station.peregon.model.StationPeregon> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.platform.model.Platform> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.support.model.Support> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.bridge.crossing.model.BridgeCrossing> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.wire.contact.model.ContactWire> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.wire.carrier.model.CarrierWire> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.canopy.model.Canopy> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsFence> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.fabula.android.synchronize.model.BodyResponse copy(@org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.measurements.type.model.MeasurementType> measurementType, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.measurements.model.Measurement> measurement, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.railway.model.Railway> railway, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.section.model.RailwaySection> railwaysector, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.station.peregon.model.StationPeregon> station, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.platform.model.Platform> platforms, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.support.model.Support> supports, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.bridge.crossing.model.BridgeCrossing> bridges, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.wire.contact.model.ContactWire> contactWire, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.wire.carrier.model.CarrierWire> carrierWire, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.canopy.model.Canopy> gabaritnaves, @org.jetbrains.annotations.NotNull()
    java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsFence> gabarittor) {
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