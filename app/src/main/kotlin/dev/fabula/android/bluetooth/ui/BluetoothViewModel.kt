package dev.fabula.android.bluetooth.ui

import androidx.lifecycle.MutableLiveData
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.bluetooth.bluetooth.MTBluetoothDevice
import javax.inject.Inject

class BluetoothViewModel @Inject constructor() : BaseViewModel() {

    val device = MutableLiveData<MTBluetoothDevice>()

    val deviceList = MutableLiveData<List<MTBluetoothDevice>>()
}