package com.example.rickandmortyaapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyaapp.common.base.BaseRepository
import com.example.rickandmortyaapp.data.network.api.EpisodeApiService
import com.example.rickandmortyaapp.data.network.dto.episode.Episode
import com.example.rickandmortyaapp.data.network.paging.EpisodePagingSource
import kotlinx.coroutines.flow.Flow

class EpisodeRepository constructor(
    private val service: EpisodeApiService
) : BaseRepository() {

    fun fetchEpisodes(): Flow<PagingData<Episode>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            pagingSourceFactory = {
                EpisodePagingSource(service)
            }
        ).flow
    }
    fun fetchEpisode(id: Int) = doRequest {
        service.fetchEpisode(id)
    }
}