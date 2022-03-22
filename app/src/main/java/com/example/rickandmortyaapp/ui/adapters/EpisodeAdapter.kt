package com.example.rickandmortyaapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyaapp.common.base.BaseComporator
import com.example.rickandmortyaapp.data.network.dto.episode.Episode
import com.example.rickandmortyaapp.databinding.ItemEpisodeBinding

class EpisodeAdapter(
) : PagingDataAdapter<Episode, EpisodeAdapter.EpisodeViewHolder>(
    BaseComporator()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    inner class EpisodeViewHolder(
        private val binding: ItemEpisodeBinding
    ) : RecyclerView.ViewHolder(binding.root) {



        fun onBind(item: Episode) = with(binding) {
            itemName.text = item.name
            itemAirDate.text = item.air_date
        }
    }
}