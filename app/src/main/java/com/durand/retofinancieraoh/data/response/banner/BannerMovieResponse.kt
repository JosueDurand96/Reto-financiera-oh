package com.durand.retofinancieraoh.data.response.banner

import com.google.gson.annotations.SerializedName

data class BannerMovieResponse(
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)