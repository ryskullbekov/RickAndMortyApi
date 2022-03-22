package com.example.rickandmortyaapp.common.base

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmortyaapp.common.base.IBaseDiffModel

class BaseComporator<T : IBaseDiffModel> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }
}