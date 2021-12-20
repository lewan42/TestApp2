package dev.fabula.android.measurements.lab.adapter

import androidx.recyclerview.widget.DiffUtil

class DiffCallbackMeasure : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem.equals(newItem)
    }
}