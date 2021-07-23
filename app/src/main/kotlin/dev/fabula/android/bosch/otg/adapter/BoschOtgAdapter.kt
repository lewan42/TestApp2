package dev.fabula.android.bosch.otg.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.fabula.android.bosch.otg.model.BoschOtgItemList
import dev.fabula.android.databinding.BoschOtgItemListBinding

typealias onItemClick = ((BoschOtgItemList) -> Unit)

class BoschOtgAdapter :
    ListAdapter<BoschOtgItemList, BoschOtgAdapter.ViewHolder>(BoschOtgDiffUtilCallback()) {

    var onItemClick: onItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            BoschOtgItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(var binding: BoschOtgItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BoschOtgItemList) {

            binding.image.setImageBitmap(item.bitmap)

            binding.image.setOnClickListener {
                onItemClick?.invoke(item)
            }

            binding.tvDateValue.text = item.date
            binding.tvFunctionValue.text = item.function
            binding.tvReferenceValue.text = item.reference
            binding.tvOperationValue.text = item.operation

            item.operation.isNullOrEmpty().let {
                binding.operationBlock.visibility = View.GONE
            }

            binding.tvMeasurementValue.text = item.measurement
            binding.tvMeasurementUnit.text = item.unit

            binding.tvMeasurementValue1.text = item.value1
            binding.tvMeasurementUnit1.text = item.unit1

            binding.tvMeasurementValue2.text = item.value2
            binding.tvMeasurementUnit2.text = item.unit2

            binding.tvMeasurementValue3.text = item.value3
            binding.tvMeasurementUnit3.text = item.unit3
        }
    }
}