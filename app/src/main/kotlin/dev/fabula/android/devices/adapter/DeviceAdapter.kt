package dev.fabula.android.devices.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.fabula.android.databinding.DevicesListItemBinding

class DeviceAdapter :
    ListAdapter<String, DeviceAdapter.ViewHolder>(DeviceDiffUtilCallback()) {

    var onItemClick: onItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DevicesListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(val binding: DevicesListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {

            binding.tvRailwayName.text = item

            binding.tvRailwayName.setOnClickListener {
                binding.checkbox.isChecked = !binding.checkbox.isChecked
                onItemClick?.invoke(item)
            }
        }
    }
}

typealias onItemClick = ((String) -> Unit)