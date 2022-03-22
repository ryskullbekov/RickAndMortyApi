package com.example.rickandmortyaapp.data.network.paging

import com.example.rickandmortyaapp.common.base.BasePagingSource
import com.example.rickandmortyaapp.data.network.api.LocationApiService
import com.example.rickandmortyaapp.data.network.dto.location.Location

class LocationPagingSource(
    private val service: LocationApiService
) : BasePagingSource<Location>({ position ->
    service.fetchLocations(position)
})