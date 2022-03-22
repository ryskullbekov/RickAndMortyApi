package com.example.rickandmortyaapp.data.network.api

import com.example.rickandmortyaapp.data.network.dto.RickAndMortyResponse
import com.example.rickandmortyaapp.data.network.dto.location.Location
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApiService {

    @GET("/api/location")
    suspend fun fetchLocations(
        @Query("page") page: Int,
    ): RickAndMortyResponse<Location>

    @GET("/api/location/{id}")
    suspend fun fetchLocation(
        @Path("id") id: Int
    ): Location
}