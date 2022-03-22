package com.example.rickandmortyaapp.data.network.paging

import com.example.rickandmortyaapp.common.base.BasePagingSource
import com.example.rickandmortyaapp.data.network.api.CharacterApiService
import com.example.rickandmortyaapp.data.network.dto.character.Character

class CharacterPagingSource (
    private val service: CharacterApiService
) : BasePagingSource<Character>({ position ->
    service.fetchCharacters(position)
})