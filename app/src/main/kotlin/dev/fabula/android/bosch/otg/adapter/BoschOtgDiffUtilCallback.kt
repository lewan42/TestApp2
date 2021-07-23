package dev.fabula.android.bosch.otg.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import dev.fabula.android.bosch.otg.model.BoschOtgItemList

class BoschOtgDiffUtilCallback : DiffUtil.ItemCallback<BoschOtgItemList>() {

    override fun areItemsTheSame(
        oldItem: BoschOtgItemList,
        newItem: BoschOtgItemList
    ): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: BoschOtgItemList,
        newItem: BoschOtgItemList
    ): Boolean {
        return oldItem == newItem
    }
}