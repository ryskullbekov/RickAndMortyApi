package com.example.rickandmortyaapp.data.network.dto.character

import com.google.gson.annotations.SerializedName

class SimpleLocation(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)