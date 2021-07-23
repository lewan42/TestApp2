package dev.fabula.android.bluetooth.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bJ\"\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001cH\u0016J-\u0010\'\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00052\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0)2\u0006\u0010+\u001a\u00020,H\u0016\u00a2\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u001cH\u0016J\u001a\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u001cH\u0002J\b\u00105\u001a\u00020\u001cH\u0003J\b\u00106\u001a\u00020\u001cH\u0002J\u0018\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020\u001cH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006<"}, d2 = {"Ldev/fabula/android/bluetooth/ui/BluetoothFragment;", "Ldev/fabula/android/app/ui/ViewModelFragment;", "Ldev/fabula/android/databinding/BluetoothFragmentBinding;", "()V", "REQUEST_CODE_ASK_PERMISSIONS_LOCATION", "", "getREQUEST_CODE_ASK_PERMISSIONS_LOCATION", "()I", "adapter", "Ldev/fabula/android/bluetooth/adapter/BluetoothMyAdapter;", "btService", "Ldev/fabula/android/bluetooth/bluetooth/BLEService;", "deviceController", "Ldev/fabula/android/bluetooth/GLMDeviceController;", "devices", "", "Ldev/fabula/android/bluetooth/bluetooth/MTBluetoothDevice;", "mConnection", "Landroid/content/ServiceConnection;", "mReceiver", "Landroid/content/BroadcastReceiver;", "viewModel", "Ldev/fabula/android/bluetooth/ui/BluetoothViewModel;", "getViewModel", "()Ldev/fabula/android/bluetooth/ui/BluetoothViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "destroyDeviceController", "", "getBluetoothService", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "refreshDeviceList", "requestLocationPermission", "setupDeviceController", "showPermissionMessageOKCancel", "message", "okListener", "Landroid/content/DialogInterface$OnClickListener;", "startDiscovery", "app_release"})
public final class BluetoothFragment extends dev.fabula.android.app.ui.ViewModelFragment<dev.fabula.android.databinding.BluetoothFragmentBinding> {
    private final kotlin.Lazy viewModel$delegate = null;
    private final int REQUEST_CODE_ASK_PERMISSIONS_LOCATION = 41;
    private dev.fabula.android.bluetooth.adapter.BluetoothMyAdapter adapter;
    private final java.util.List<dev.fabula.android.bluetooth.bluetooth.MTBluetoothDevice> devices = null;
    private dev.fabula.android.bluetooth.bluetooth.BLEService btService;
    private dev.fabula.android.bluetooth.GLMDeviceController deviceController;
    
    /**
     * Binds the Bluetooth service to the activity
     */
    private final android.content.ServiceConnection mConnection = null;
    
    /**
     * The BroadcastReceiver that handles notifications for discovered devices and new measurements
     */
    private final android.content.BroadcastReceiver mReceiver = null;
    private java.util.HashMap _$_findViewCache;
    
    private final dev.fabula.android.bluetooth.ui.BluetoothViewModel getViewModel() {
        return null;
    }
    
    public final int getREQUEST_CODE_ASK_PERMISSIONS_LOCATION() {
        return 0;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Initializes the GLMDeviceController class, that will handle messages from and to GLM device
     */
    private final void setupDeviceController() {
    }
    
    /**
     * Destroys the GLMDeviceController, when it is not needed anymore
     */
    private final void destroyDeviceController() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @android.annotation.TargetApi(value = 23)
    private final void requestLocationPermission() {
    }
    
    private final void showPermissionMessageOKCancel(java.lang.String message, android.content.DialogInterface.OnClickListener okListener) {
    }
    
    /**
     * Used to refresh the device list shown. If Bluetooth scanning is not enabled, the list will be empty
     */
    private final synchronized void refreshDeviceList() {
    }
    
    /**
     * Triggers discovery of Bluetooth devices for 5 seconds
     */
    private final void startDiscovery() {
    }
    
    /**
     * Get the binded BLEService
     * @return binded BLEService
     */
    @org.jetbrains.annotations.Nullable()
    public final dev.fabula.android.bluetooth.bluetooth.BLEService getBluetoothService() {
        return null;
    }
    
    public BluetoothFragment() {
        super();
    }
}