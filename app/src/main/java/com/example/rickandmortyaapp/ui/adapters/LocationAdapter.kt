package com.example.rickandmortyaapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyaapp.data.network.dto.location.Location
import com.example.rickandmortyaapp.common.base.BaseComporator
import com.example.rickandmortyaapp.databinding.ItemLocationBinding

class LocationAdapter(

) : PagingDataAdapter<Location, LocationAdapter.LocationViewHolder>(
    BaseComporator()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    inner class LocationViewHolder(
        private val binding: ItemLocationBinding
    ) : RecyclerView.ViewHolder(binding.root) {





        fun onBind(item: Location) = with(binding) {
            itemName.text = item.name
            itemType.text = item.type
        }
    }
}