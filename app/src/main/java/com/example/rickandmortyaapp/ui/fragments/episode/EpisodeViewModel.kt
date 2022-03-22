package com.example.rickandmortyaapp.ui.fragments.episode

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyaapp.common.base.BaseViewModel
import com.example.rickandmortyaapp.data.repository.EpisodeRepository

class EpisodeViewModel constructor(
    private val repository: EpisodeRepository
) : BaseViewModel() {
    fun fetchEpisode() = repository.fetchEpisodes().cachedIn(viewModelScope)
}