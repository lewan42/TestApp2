package dev.fabula.android.list.items.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.fabula.android.databinding.RailwayItemBinding
import dev.fabula.android.list.items.model.ListItem
import java.util.*

typealias onItemClick = ((ListItem) -> Unit)

class ListItemsAdapter(private val obj: String) :
    ListAdapter<ListItem, ListItemsAdapter.ViewHolder>(ListItemsDiffUtilCallback()) {

    var onItemClick: onItemClick? = null

    private var constantListItem: List<ListItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            RailwayItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    fun filter(query: CharSequence?) {
        if (constantListItem.isEmpty())
            constantListItem = currentList

        val list = mutableListOf<ListItem>()

        if (!query.isNullOrEmpty()) {
            list.addAll(constantListItem.filter {
                it.name.toLowerCase(Locale.getDefault())
                    .contains(query.toString().toLowerCase(Locale.getDefault())) ||
                        it.name.toLowerCase(Locale.getDefault())
                            .contains(query.toString().toLowerCase(Locale.getDefault()))
            })
        } else {
            list.addAll(constantListItem)
        }

        submitList(list)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }

    inner class ViewHolder(val binding: RailwayItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: ListItem, pos: Int) {

            binding.btnAction.text = "$obj ${(pos + 1)}"

            binding.btnAction.setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}