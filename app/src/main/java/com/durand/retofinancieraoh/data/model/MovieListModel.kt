package com.durand.retofinancieraoh.data.model

import com.google.gson.annotations.SerializedName

data class MovieListModel(
    @SerializedName("data")
    val data: List<MovieModel>
)