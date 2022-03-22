package com.example.rickandmortyaapp.data.network.api

import com.example.rickandmortyaapp.data.network.dto.RickAndMortyResponse
import com.example.rickandmortyaapp.data.network.dto.character.Character
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("/api/character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
    ): RickAndMortyResponse<Character>


    @GET("/api/character/{id}")
    suspend fun fetchCharacter(
        @Path("id") id: Int
    ): Character
}