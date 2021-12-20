package dev.fabula.android.measurements.create.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.fabula.android.measurements.model.MeasureCalc

class CreateMeasurementsListDiffUtilCallback : DiffUtil.ItemCallback<MeasureCalc>() {

    override fun areItemsTheSame(
        oldItem: MeasureCalc,
        newItem: MeasureCalc
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: MeasureCalc,
        newItem: MeasureCalc
    ): Boolean {
        return oldItem.equals(newItem)
    }
}