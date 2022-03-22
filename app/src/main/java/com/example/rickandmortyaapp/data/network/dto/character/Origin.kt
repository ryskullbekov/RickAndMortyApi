package com.example.rickandmortyaapp.data.network.dto.character

import com.google.gson.annotations.SerializedName

class Origin (
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)