package com.example.rickandmortyaapp.ui.adapters.pagin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyaapp.databinding.ItemLoadBinding

class LoadViewHolder(
    private val binding: ItemLoadBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.retryButton.setOnClickListener {
            retry.invoke()
        }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            
        }
        binding.progressBar.isVisible = loadState is LoadState.Loading
        binding.retryButton.isVisible = loadState is LoadState.Error

    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): LoadViewHolder {
            return LoadViewHolder(
                ItemLoadBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ),
                retry
            )
        }
    }
}