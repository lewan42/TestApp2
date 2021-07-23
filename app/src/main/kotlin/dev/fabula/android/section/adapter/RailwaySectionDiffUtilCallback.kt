package dev.fabula.android.section.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.fabula.android.section.model.RailwaySection

class RailwaySectionDiffUtilCallback : DiffUtil.ItemCallback<RailwaySection>() {

    override fun areItemsTheSame(oldItem: RailwaySection, newItem: RailwaySection): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: RailwaySection, newItem: RailwaySection): Boolean {
        return oldItem == newItem
    }
}