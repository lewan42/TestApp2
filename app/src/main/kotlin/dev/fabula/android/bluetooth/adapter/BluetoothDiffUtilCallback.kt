package dev.fabula.android.bluetooth.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import dev.fabula.android.bluetooth.bluetooth.MTBluetoothDevice

class BluetoothDiffUtilCallback : DiffUtil.ItemCallback<MTBluetoothDevice>() {

    override fun areItemsTheSame(oldItem: MTBluetoothDevice, newItem: MTBluetoothDevice): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: MTBluetoothDevice, newItem: MTBluetoothDevice): Boolean {
        return oldItem == newItem
    }
}