package com.durand.retofinancieraoh.data.response.peli

import com.google.gson.annotations.SerializedName

data class MovieMasterResponse(
    @SerializedName("data")
    val data: List<PeliMovieResponse>
)