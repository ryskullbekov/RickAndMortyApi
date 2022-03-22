package com.example.rickandmortyaapp.data.network.paging

import com.example.rickandmortyaapp.common.base.BasePagingSource
import com.example.rickandmortyaapp.data.network.api.EpisodeApiService
import com.example.rickandmortyaapp.data.network.dto.episode.Episode

class EpisodePagingSource(
    private val service: EpisodeApiService
) : BasePagingSource<Episode>({ position ->
    service.fetchEpisodes(position)
})