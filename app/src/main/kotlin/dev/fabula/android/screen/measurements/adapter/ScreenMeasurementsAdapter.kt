package dev.fabula.android.screen.measurements.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.fabula.android.databinding.RailwayItemBinding
import dev.fabula.android.screen.measurements.model.ListItem

typealias onItemClick = ((ListItem) -> Unit)

class ScreenMeasurementsAdapter :
    ListAdapter<ListItem, ScreenMeasurementsAdapter.ViewHolder>(ScreenMeasurementsDiffUtilCallback()) {

    var onItemClick: onItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            RailwayItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(val binding: RailwayItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItem) {

            binding.btnAction.text = item.name

            binding.btnAction.setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}