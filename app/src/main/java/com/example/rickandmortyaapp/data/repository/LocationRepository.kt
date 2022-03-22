package com.example.rickandmortyaapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyaapp.common.base.BaseRepository
import com.example.rickandmortyaapp.data.network.api.LocationApiService
import com.example.rickandmortyaapp.data.network.dto.location.Location
import com.example.rickandmortyaapp.data.network.paging.LocationPagingSource
import kotlinx.coroutines.flow.Flow

class LocationRepository  constructor(
    private val service: LocationApiService
) : BaseRepository() {

    fun fetchLocations(): Flow<PagingData<Location>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            pagingSourceFactory = {
                LocationPagingSource(service)
            }
        ).flow
    }

    fun fetchLocation(id: Int) = doRequest {
        service.fetchLocation(id)
    }
}