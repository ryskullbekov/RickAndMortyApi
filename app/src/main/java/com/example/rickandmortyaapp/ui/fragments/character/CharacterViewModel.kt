package com.example.rickandmortyaapp.ui.fragments.character

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyaapp.common.base.BaseViewModel
import com.example.rickandmortyaapp.data.repository.CharacterRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : BaseViewModel() {
    fun fetchCharacters() = repository.fetchCharacters().cachedIn(viewModelScope)
}