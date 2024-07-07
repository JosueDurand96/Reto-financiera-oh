package com.durand.retofinancieraoh.data.response.peli

import com.google.gson.annotations.SerializedName

data class PeliMovieResponse(
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String
)