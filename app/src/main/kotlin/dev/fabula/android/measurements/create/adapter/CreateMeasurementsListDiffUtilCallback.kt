package dev.fabula.android.measurements.create.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.fabula.android.measurements.model.BoschMeasurements

class CreateMeasurementsListDiffUtilCallback : DiffUtil.ItemCallback<BoschMeasurements>() {

    override fun areItemsTheSame(
        oldItem: BoschMeasurements,
        newItem: BoschMeasurements
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: BoschMeasurements,
        newItem: BoschMeasurements
    ): Boolean {
        return oldItem.equals(newItem)
    }
}