package com.example.rickandmortyaapp.data.network.dto.location

import com.example.rickandmortyaapp.common.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("residents")
    val residents: MutableList<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
) : IBaseDiffModel