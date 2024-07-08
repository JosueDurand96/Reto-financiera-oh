package com.durand.retofinancieraoh.data.response.candy

import com.google.gson.annotations.SerializedName

data class CandyMasterResponse(
    @SerializedName("data")
    val data: List<CandyResponse>
)