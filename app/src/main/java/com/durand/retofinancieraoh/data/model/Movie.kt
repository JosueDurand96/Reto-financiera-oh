package com.durand.retofinancieraoh.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String
)