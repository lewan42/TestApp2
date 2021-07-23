package dev.fabula.android.app.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldev/fabula/android/app/util/Util;", "", "()V", "Companion", "app_release"})
public final class Util {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_SYNC_CONNECTION_RECEIVED = "ACTION_SYNC_CONNECTION_RECEIVED";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_SYNC_CONNECTION_RECEIVED_STATE = "ACTION_SYNC_CONNECTION_RECEIVED_STATE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String station = "Station";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String stationName = "\u0421\u0442\u0430\u043d\u0446\u0438\u044f";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String platform = "\u041f\u043b\u0430\u0442\u0444\u043e\u0440\u043c\u0430";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String canopy = "\u041d\u0430\u0432\u0435\u0441";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String bridgeCrossing = "\u041c\u043e\u0441\u0442\u043e\u0432\u043e\u0439 \u043f\u0435\u0440\u0435\u0445\u043e\u0434";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String support = "\u043e\u043f\u043e\u0440\u0430";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String supportName = "\u041e\u043f\u043e\u0440\u0430";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String sectionRailway = "\u0423\u0447\u0430\u0441\u0442\u043e\u043a \u0436\u0435\u043b\u0435\u0437\u043d\u043e\u0439 \u0434\u043e\u0440\u043e\u0433\u0438";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String peregon = "Peregon";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String peregonName = "\u041f\u0435\u0440\u0435\u0433\u043e\u043d";
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<android.nfc.Tag> NFC_TAG;
    private static boolean NFC_TAG_NEXT = true;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String BOSCH_DEVICE = "";
    private static boolean STATE_BLUETOOTH_CONNECTION = false;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String CERTIFICATE_1 = "\u0413\u043e\u0441\u0440\u0435\u0435\u0441\u0442\u0440 \u2116 44551- 10, \u0437\u0430\u0432\u043e\u0434\u0441\u043a\u043e\u0438\u0306 \u2116 806325544, \u0438\u043d\u0432. \u2116 580000026941.";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String CERTIFICATE_2 = "\u0421\u0432\u0438\u0434\u0435\u0442\u0435\u043b\u044c\u0441\u0442\u0432\u043e \u043e \u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0435 No 380342, \u0434\u0435\u0438\u0306\u0441\u0442\u0432\u0438\u0442\u0435\u043b\u044c\u043d\u043e \u0434\u043e 24 \u0444\u0435\u0432\u0440\u0430\u043b\u044f 2021 \u0433\u043e\u0434\u0430.";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String CERTIFICATE_3 = "\u0423\u0428\u0413 00.000. \u0437\u0430\u0432. \u2116 580000009030.";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String CERTIFICATE_4 = "\u0421\u0435\u0440\u0442\u0438\u0444\u0438\u043a\u0430\u0442 \u2116 \u0415/3368, \u0434\u0435\u0438\u0306\u0441\u0442\u0432\u0438\u0442\u0435\u043b\u0435\u043d \u0434\u043e 04 \u0438\u044e\u043d\u044f 2020 \u0433\u043e\u0434\u0430.";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String CERTIFICATE_5 = "\u041b\u0430\u0437\u0435\u0440\u043d\u044b\u0439 \u0434\u0430\u043b\u044c\u043d\u043e\u043c\u0435\u0440 Bosch GLM 250 VF Professional \u211680627 LC .";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String type_create_measurement = "Create";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String type_update_measurement = "Update";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String platform_peregovay = "\u0411\u0435\u0440\u0435\u0433\u043e\u0432\u0430\u044f";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String platform_ostravnaya = "\u041e\u0441\u0442\u0440\u043e\u0432\u043d\u0430\u044f";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String platform_high = "\u0412\u044b\u0441\u043e\u043a\u0430\u044f";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String platform_down = "\u041d\u0438\u0437\u043a\u0430\u044f";
    public static final int canopy_type_north = 0;
    public static final int canopy_type_center = 1;
    public static final int canopy_type_south = 2;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String height_contact_wire = "\u0432\u044b\u0441\u043e\u0442\u0430 \u043a\u043e\u043d\u0442\u0430\u043a\u0442\u043d\u043e\u0433\u043e \u043f\u0440\u043e\u0432\u043e\u0434\u0430";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String zigzag_contact_wire = "\u0437\u0438\u0433\u0437\u0430\u0433 \u043a\u043e\u043d\u0442\u0430\u043a\u0442\u043d\u043e\u0433\u043e \u043f\u0440\u043e\u0432\u043e\u0434\u0430";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String height_carrier_wire = "\u0432\u044b\u0441\u043e\u0442\u0430 \u043d\u0435\u0441\u0443\u0449\u0435\u0433\u043e \u043f\u0440\u043e\u0432\u043e\u0434\u0430";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String zigzag_carrier_wire = "\u0437\u0438\u0433\u0437\u0430\u0433 \u043d\u0435\u0441\u0443\u0449\u0435\u0433\u043e \u043f\u0440\u043e\u0432\u043e\u0434\u0430";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String support_type = "\u043e\u043f\u043e\u0440\u0430";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String support_bridge_type = "\u043e\u043f\u043e\u0440\u0430 \u043c\u043e\u0441\u0442\u043e\u0432\u043e\u0433\u043e \u043f\u0435\u0440\u0435\u0445\u043e\u0434\u0430";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String platform_type_measurement = "\u043f\u043b\u0430\u0442\u0444\u043e\u0440\u043c\u0430";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String dimensions_fence_type = "\u0433\u0430\u0431\u0430\u0440\u0438\u0442 \u0442\u043e\u0440\u0446\u0435\u0432\u043e\u0433\u043e \u043e\u0433\u0440\u0430\u0436\u0434\u0435\u043d\u0438\u044f";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String dimensions_canopy_type = "\u0433\u0430\u0431\u0430\u0440\u0438\u0442 \u043d\u0430\u0432\u0435\u0441\u0430";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String bridge_down = "\u0441\u043f\u0443\u0441\u043a \u043c\u043e\u0441\u0442\u043e\u0432\u043e\u0433\u043e \u043f\u0435\u0440\u0435\u0445\u043e\u0434\u0430";
    private static int HEIGHT_NORM = 0;
    private static int WIDTH_NORM = 0;
    public static final dev.fabula.android.app.util.Util.Companion Companion = null;
    
    public Util() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b*\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010P\u001a\u00020\u00042\b\u0010Q\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001a\u00100\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u000e\u00103\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006R"}, d2 = {"Ldev/fabula/android/app/util/Util$Companion;", "", "()V", "ACTION_SYNC_CONNECTION_RECEIVED", "", "ACTION_SYNC_CONNECTION_RECEIVED_STATE", "BOSCH_DEVICE", "getBOSCH_DEVICE", "()Ljava/lang/String;", "setBOSCH_DEVICE", "(Ljava/lang/String;)V", "CERTIFICATE_1", "getCERTIFICATE_1", "setCERTIFICATE_1", "CERTIFICATE_2", "getCERTIFICATE_2", "setCERTIFICATE_2", "CERTIFICATE_3", "getCERTIFICATE_3", "setCERTIFICATE_3", "CERTIFICATE_4", "getCERTIFICATE_4", "setCERTIFICATE_4", "CERTIFICATE_5", "getCERTIFICATE_5", "setCERTIFICATE_5", "HEIGHT_NORM", "", "getHEIGHT_NORM", "()I", "setHEIGHT_NORM", "(I)V", "NFC_TAG", "Landroidx/lifecycle/MutableLiveData;", "Landroid/nfc/Tag;", "getNFC_TAG", "()Landroidx/lifecycle/MutableLiveData;", "setNFC_TAG", "(Landroidx/lifecycle/MutableLiveData;)V", "NFC_TAG_NEXT", "", "getNFC_TAG_NEXT", "()Z", "setNFC_TAG_NEXT", "(Z)V", "STATE_BLUETOOTH_CONNECTION", "getSTATE_BLUETOOTH_CONNECTION", "setSTATE_BLUETOOTH_CONNECTION", "WIDTH_NORM", "getWIDTH_NORM", "setWIDTH_NORM", "bridgeCrossing", "bridge_down", "canopy", "canopy_type_center", "canopy_type_north", "canopy_type_south", "dimensions_canopy_type", "dimensions_fence_type", "height_carrier_wire", "height_contact_wire", "peregon", "peregonName", "platform", "platform_down", "platform_high", "platform_ostravnaya", "platform_peregovay", "platform_type_measurement", "sectionRailway", "station", "stationName", "support", "supportName", "support_bridge_type", "support_type", "type_create_measurement", "type_update_measurement", "zigzag_carrier_wire", "zigzag_contact_wire", "cutMeasurement", "str", "app_release"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.MutableLiveData<android.nfc.Tag> getNFC_TAG() {
            return null;
        }
        
        public final void setNFC_TAG(@org.jetbrains.annotations.NotNull()
        androidx.lifecycle.MutableLiveData<android.nfc.Tag> p0) {
        }
        
        public final boolean getNFC_TAG_NEXT() {
            return false;
        }
        
        public final void setNFC_TAG_NEXT(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBOSCH_DEVICE() {
            return null;
        }
        
        public final void setBOSCH_DEVICE(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean getSTATE_BLUETOOTH_CONNECTION() {
            return false;
        }
        
        public final void setSTATE_BLUETOOTH_CONNECTION(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCERTIFICATE_1() {
            return null;
        }
        
        public final void setCERTIFICATE_1(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCERTIFICATE_2() {
            return null;
        }
        
        public final void setCERTIFICATE_2(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCERTIFICATE_3() {
            return null;
        }
        
        public final void setCERTIFICATE_3(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCERTIFICATE_4() {
            return null;
        }
        
        public final void setCERTIFICATE_4(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCERTIFICATE_5() {
            return null;
        }
        
        public final void setCERTIFICATE_5(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final int getHEIGHT_NORM() {
            return 0;
        }
        
        public final void setHEIGHT_NORM(int p0) {
        }
        
        public final int getWIDTH_NORM() {
            return 0;
        }
        
        public final void setWIDTH_NORM(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String cutMeasurement(@org.jetbrains.annotations.Nullable()
        java.lang.String str) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}