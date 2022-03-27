package com.example.rickandmortyaapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.rickandmortyaapp.common.base.BaseRepository
import com.example.rickandmortyaapp.data.network.api.CharacterApiService
import com.example.rickandmortyaapp.data.network.dto.character.Character
import com.example.rickandmortyaapp.data.network.paging.CharacterPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharacterApiService
) : BaseRepository() {

    fun fetchCharacters(): LiveData<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            pagingSourceFactory = {
                CharacterPagingSource(service)
            }
        ).liveData
    }

    fun fetchCharacter(id: Int) = doRequest {
        service.fetchCharacter(id)
    }
}