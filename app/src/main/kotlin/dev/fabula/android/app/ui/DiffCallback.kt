package dev.fabula.android.app.ui

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class CustomDiffCallback<T>(val sm: (T, T) -> Boolean) : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return sm(oldItem, newItem)
    }


    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}