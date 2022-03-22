package com.example.rickandmortyaapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyaapp.common.base.BaseRepository
import com.example.rickandmortyaapp.data.network.api.CharacterApiService
import com.example.rickandmortyaapp.data.network.dto.character.Character
import com.example.rickandmortyaapp.data.network.paging.CharacterPagingSource
import kotlinx.coroutines.flow.Flow

class CharacterRepository constructor(
    private val service: CharacterApiService
) : BaseRepository() {

    fun fetchCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            pagingSourceFactory = {
                CharacterPagingSource(service)
            }
        ).flow
    }

    fun fetchCharacter(id: Int) = doRequest {
        service.fetchCharacter(id)
    }
}