package com.durand.retofinancieraoh.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)