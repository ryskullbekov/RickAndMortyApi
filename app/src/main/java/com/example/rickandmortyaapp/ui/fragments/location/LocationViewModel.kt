package com.example.rickandmortyaapp.ui.fragments.location

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyaapp.common.base.BaseViewModel
import com.example.rickandmortyaapp.data.repository.LocationRepository

class LocationViewModel constructor(
    private val repository: LocationRepository
) : BaseViewModel() {
    fun fetchLocations() = repository.fetchLocations().cachedIn(viewModelScope)
}
