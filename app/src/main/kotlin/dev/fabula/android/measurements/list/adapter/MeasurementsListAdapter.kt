package dev.fabula.android.measurements.list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.fabula.android.databinding.MeasureListFragmentItemBinding
import dev.fabula.android.databinding.RailwayFragmentBinding
import dev.fabula.android.dimensions.fence.model.DimensionsFenceWithMeasurement
import dev.fabula.android.measurements.model.Measurement

typealias onItemClick = ((Any) -> Unit)

class MeasurementsListAdapter :
    ListAdapter<Any, MeasurementsListAdapter.ViewHolder>(AnyMeasurementsListDiffUtilCallback()) {

    var onItemClick: onItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            MeasureListFragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }

    inner class ViewHolder(val binding: MeasureListFragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat", "SetTextI18n")

        fun bind(item: Any, pos: Int) {

            binding.numberRow.text = "${(pos + 1)}."

            binding.info.setOnClickListener {
                onItemClick?.invoke(item)
            }

            when (item) {
                is Measurement -> {
                    binding.measureL.text = "L = ${item.horizontal_gabarit}"
                    binding.measureH.text = "H = ${item.vertical_gabarit}"

                    val sdf = java.text.SimpleDateFormat("dd-MM-yyyy")
                    val date = java.util.Date(item.created_at * 1000)
                    binding.date.text = sdf.format(date)
                    binding.text.visibility = View.GONE
                    binding.direction.visibility = View.GONE
                }

                is DimensionsFenceWithMeasurement -> {
                    item.measurements?.let { measure ->
                        binding.measureL.text = "L = ${measure.horizontal_gabarit}"
                        binding.measureH.text = "H = ${measure.vertical_gabarit}"

                        val sdf = java.text.SimpleDateFormat("dd-MM-yyyy")
                        val date = java.util.Date(measure.created_at * 1000)
                        binding.date.text = sdf.format(date)
                        binding.direction.text = item.dimensionsFence.direction
                    }
                }
            }
        }
    }
}