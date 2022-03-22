package com.example.rickandmortyaapp.data.network.api

import com.example.rickandmortyaapp.data.network.dto.RickAndMortyResponse
import com.example.rickandmortyaapp.data.network.dto.episode.Episode
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("/api/episode")
    suspend fun fetchEpisodes(
        @Query("page") page: Int,
    ): RickAndMortyResponse<Episode>

    @GET("/api/episode/{id}")
    suspend fun fetchEpisode(
        @Path("id") id: Int
    ): Episode
}