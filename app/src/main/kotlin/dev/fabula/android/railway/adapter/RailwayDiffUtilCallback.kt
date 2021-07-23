package dev.fabula.android.railway.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.fabula.android.platform.model.Platform
import dev.fabula.android.railway.model.Railway


class RailwayDiffUtilCallback : DiffUtil.ItemCallback<Railway>() {

    override fun areItemsTheSame(oldItem: Railway, newItem: Railway): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Railway, newItem: Railway): Boolean {
        return oldItem == newItem
    }
}

class PlatformDiffUtilCallback : DiffUtil.ItemCallback<Platform>() {

    override fun areItemsTheSame(oldItem: Platform, newItem: Platform): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: Platform, newItem: Platform): Boolean {
        return oldItem == newItem
    }
}