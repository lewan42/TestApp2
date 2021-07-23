package dev.fabula.android.screen.measurements.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.fabula.android.screen.measurements.model.ListItem

class ScreenMeasurementsDiffUtilCallback : DiffUtil.ItemCallback<ListItem>() {

    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem == newItem
    }
}