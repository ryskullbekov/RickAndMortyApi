package com.example.rickandmortyaapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.rickandmortyaapp.common.base.BaseRepository
import com.example.rickandmortyaapp.data.network.api.LocationApiService
import com.example.rickandmortyaapp.data.network.dto.location.Location
import com.example.rickandmortyaapp.data.network.paging.LocationPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepository  @Inject constructor(
    private val service: LocationApiService
) : BaseRepository() {

    fun fetchLocations(): LiveData<PagingData<Location>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            pagingSourceFactory = {
                LocationPagingSource(service)
            }
        ).liveData
    }

    fun fetchLocation(id: Int) = doRequest {
        service.fetchLocation(id)
    }
}