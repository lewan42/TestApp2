package dev.fabula.android.bluetooth.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Ldev/fabula/android/bluetooth/ui/BluetoothViewModel;", "Ldev/fabula/android/app/ui/BaseViewModel;", "()V", "device", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/bluetooth/bluetooth/MTBluetoothDevice;", "getDevice", "()Landroidx/lifecycle/MutableLiveData;", "deviceList", "", "getDeviceList", "app_release"})
public final class BluetoothViewModel extends dev.fabula.android.app.ui.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.bluetooth.bluetooth.MTBluetoothDevice> device = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<dev.fabula.android.bluetooth.bluetooth.MTBluetoothDevice>> deviceList = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<dev.fabula.android.bluetooth.bluetooth.MTBluetoothDevice> getDevice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<dev.fabula.android.bluetooth.bluetooth.MTBluetoothDevice>> getDeviceList() {
        return null;
    }
    
    @javax.inject.Inject()
    public BluetoothViewModel() {
        super();
    }
}