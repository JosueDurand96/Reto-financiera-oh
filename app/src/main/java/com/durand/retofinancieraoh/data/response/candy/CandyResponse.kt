package com.durand.retofinancieraoh.data.response.candy

import com.google.gson.annotations.SerializedName

data class CandyResponse(
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("precio")
    val price: String,
    @SerializedName("description")
    val description: String
)