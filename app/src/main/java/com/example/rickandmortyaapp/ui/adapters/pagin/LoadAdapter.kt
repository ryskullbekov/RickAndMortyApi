package com.example.rickandmortyaapp.ui.adapters.pagin

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class LoadAdapter(private val retry: () -> Unit) : LoadStateAdapter<LoadViewHolder>() {
    override fun onBindViewHolder(holder: LoadViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, loadState: LoadState
    ): LoadViewHolder {
        return LoadViewHolder.create(parent, retry)
    }
}