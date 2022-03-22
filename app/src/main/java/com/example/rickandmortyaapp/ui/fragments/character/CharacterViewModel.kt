package com.example.rickandmortyaapp.ui.fragments.character

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyaapp.common.base.BaseViewModel
import com.example.rickandmortyaapp.data.repository.CharacterRepository

class CharacterViewModel constructor(
    private val repository: CharacterRepository
) : BaseViewModel() {
    fun fetchCharacters() = repository.fetchCharacters().cachedIn(viewModelScope)
}