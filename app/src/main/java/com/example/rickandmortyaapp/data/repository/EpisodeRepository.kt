package com.example.rickandmortyaapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.rickandmortyaapp.common.base.BaseRepository
import com.example.rickandmortyaapp.data.network.api.EpisodeApiService
import com.example.rickandmortyaapp.data.network.dto.episode.Episode
import com.example.rickandmortyaapp.data.network.paging.EpisodePagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val service: EpisodeApiService
) : BaseRepository() {

    fun fetchEpisodes(): LiveData<PagingData<Episode>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            pagingSourceFactory = {
                EpisodePagingSource(service)
            }
        ).liveData
    }
    fun fetchEpisode(id: Int) = doRequest {
        service.fetchEpisode(id)
    }
}