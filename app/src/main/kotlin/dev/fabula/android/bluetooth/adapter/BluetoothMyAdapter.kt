package dev.fabula.android.bluetooth.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.fabula.android.app.util.Util
import dev.fabula.android.bluetooth.bluetooth.BLEService
import dev.fabula.android.bluetooth.bluetooth.MTBluetoothDevice
import dev.fabula.android.bluetooth.ui.BluetoothFragment
import dev.fabula.android.databinding.BluetoothItemListBinding

typealias onItemClick = ((MTBluetoothDevice) -> Unit)

class BluetoothMyAdapter(private val bluetoothFragment: BluetoothFragment) :
    ListAdapter<MTBluetoothDevice, BluetoothMyAdapter.ViewHolder>(BluetoothDiffUtilCallback()) {

    var onItemClick: onItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            BluetoothItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), bluetoothFragment
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(
        val binding: BluetoothItemListBinding,
        private val bluetoothFragment: BluetoothFragment
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MTBluetoothDevice) {

            binding.boschName.text = item.displayName

            binding.boschName.setOnClickListener {
                binding.checkbox.isChecked = !binding.checkbox.isChecked
                onItemClick?.invoke(item)
            }

            val btService: BLEService? = bluetoothFragment.getBluetoothService()

            if (btService != null) {
                btService.currentDevice?.let {
                    val currentDevice: MTBluetoothDevice = btService.currentDevice
                    if (currentDevice.device.address.equals(item.device.address)) {
                        binding.checkbox.isChecked = btService.isConnected
                        Util.BOSCH_DEVICE = currentDevice.displayName
                    }
                }
            }
        }
    }
}