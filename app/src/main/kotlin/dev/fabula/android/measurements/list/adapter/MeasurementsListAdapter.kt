package dev.fabula.android.measurements.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.fabula.android.databinding.MeasureListFragmentItemBinding
import dev.fabula.android.databinding.RailwayItemBinding
import dev.fabula.android.list.items.model.ListItem
import dev.fabula.android.measurements.model.Measurement

typealias onItemClick = ((Measurement) -> Unit)

class MeasurementsListAdapter(private val objMeasure: String) :
    ListAdapter<Measurement, MeasurementsListAdapter.ViewHolder>(MeasurementsListDiffUtilCallback()) {

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
        holder.bind(item, position, objMeasure)
    }

    inner class ViewHolder(val binding: MeasureListFragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Measurement, pos: Int, objMeasure: String) {

            binding.numberRow.text = "${(pos + 1)}."

            binding.info.setOnClickListener {
                onItemClick?.invoke(item)
            }

            binding.measureL.text = "L = " + item.horizontal_gabarit
            binding.measureH.text = "H = " + item.vertical_gabarit

            val sdf = java.text.SimpleDateFormat("dd-MM-yyyy")
            val date = java.util.Date(item.created_at * 1000)
            binding.date.text = sdf.format(date)
        }
    }
}