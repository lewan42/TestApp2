package dev.fabula.android.measurements.list.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.fabula.android.measurements.model.Measurement

class MeasurementsListDiffUtilCallback : DiffUtil.ItemCallback<Measurement>() {

    override fun areItemsTheSame(oldItem: Measurement, newItem: Measurement): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Measurement, newItem: Measurement): Boolean {
        return oldItem == newItem
    }
}