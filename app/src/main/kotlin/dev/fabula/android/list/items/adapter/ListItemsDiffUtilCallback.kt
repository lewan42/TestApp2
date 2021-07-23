package dev.fabula.android.list.items.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.fabula.android.list.items.model.ListItem

class ListItemsDiffUtilCallback : DiffUtil.ItemCallback<ListItem>() {

    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem == newItem
    }
}