package dev.fabula.android.measurements.lab.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.fabula.android.databinding.LabFragmentItemListBinding
import dev.fabula.android.measurements.model.MeasureCalc

typealias onItemClick = ((Int) -> Unit)

class LabMeasureAdapter(var typeMeasure: String) :
    ListAdapter<String, LabMeasureAdapter.ViewHolder>(
        DiffCallbackMeasure()
    ) {

    var onItemClick: onItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LabFragmentItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }

    inner class ViewHolder(val binding: LabFragmentItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: String, pos: Int) {
            binding.numberMeasure.text = "${(pos + 1)}. "
            binding.height.text = item
            binding.typeMeasurementText.text = typeMeasure

            binding.btnDel.setOnClickListener {
                onItemClick?.invoke(pos)
            }
        }
    }
}