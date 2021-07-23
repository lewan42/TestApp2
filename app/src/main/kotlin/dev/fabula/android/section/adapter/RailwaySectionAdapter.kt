package dev.fabula.android.section.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.fabula.android.databinding.RailwayItemBinding
import dev.fabula.android.section.model.RailwaySection

class RailwaySectionAdapter :
    ListAdapter<RailwaySection, RailwaySectionAdapter.ViewHolder>(RailwaySectionDiffUtilCallback()) {

    var onItemClick: onItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RailwayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RailwaySectionAdapter.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(val binding: RailwayItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RailwaySection) {

            binding.btnAction.text = item.name

            binding.btnAction.setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}

typealias onItemClick = ((RailwaySection) -> Unit)