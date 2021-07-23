package dev.fabula.android.railway.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.fabula.android.databinding.RailwayItemBinding
import dev.fabula.android.railway.model.Railway

typealias OnItemClick = ((Railway) -> Unit)

class RailwayAdapter :
    ListAdapter<Railway, RailwayAdapter.ViewHolder>(RailwayDiffUtilCallback()) {

    var onItemClick: OnItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RailwayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RailwayAdapter.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(val binding: RailwayItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Railway) {

            binding.btnAction.text = item.name

            binding.btnAction.setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}

