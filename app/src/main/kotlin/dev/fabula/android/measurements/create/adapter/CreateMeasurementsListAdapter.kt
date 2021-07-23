package dev.fabula.android.measurements.create.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.fabula.android.R
import dev.fabula.android.databinding.CreateMeasurementItemListBinding
import dev.fabula.android.list.items.model.ListItem
import dev.fabula.android.measurements.model.BoschMeasurements

typealias onItemClick = ((BoschMeasurements) -> Unit)

class CreateMeasurementsListAdapter :
    ListAdapter<BoschMeasurements, CreateMeasurementsListAdapter.ViewHolder>(
        CreateMeasurementsListDiffUtilCallback()
    ) {

    var onItemClick: onItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            CreateMeasurementItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }

    inner class ViewHolder(val binding: CreateMeasurementItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: BoschMeasurements, pos: Int) {

            binding.info.setOnClickListener {
                onItemClick?.invoke(item)
            }

            binding.numberMeasure.text = "${pos + 1}."
            binding.length.text = item.length
            binding.height.text = item.height

            if(item.isMeasureOverNormal){
                binding.info.setImageResource(R.drawable.ic_info_red)
            }else{
                binding.info.setImageResource(R.drawable.ic_info_green)
            }
        }
    }
}