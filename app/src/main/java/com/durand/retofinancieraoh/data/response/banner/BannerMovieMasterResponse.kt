package com.durand.retofinancieraoh.data.response.banner

import com.google.gson.annotations.SerializedName

data class BannerMovieMasterResponse(
    @SerializedName("data")
    val data: List<BannerMovieResponse>
)