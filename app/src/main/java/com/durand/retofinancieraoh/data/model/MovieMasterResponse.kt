package com.durand.retofinancieraoh.data.model

import com.google.gson.annotations.SerializedName

data class MovieMasterResponse(
    @SerializedName("data")
    val data: List<MovieResponse>
)