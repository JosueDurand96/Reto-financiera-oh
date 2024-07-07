package com.durand.retofinancieraoh.data.repository

import android.util.Log
import com.durand.retofinancieraoh.data.response.banner.BannerMovieMasterResponse
import com.durand.retofinancieraoh.data.response.peli.MovieMasterResponse
import com.durand.retofinancieraoh.data.service.BannerService
import javax.inject.Inject

class PeliRepository @Inject constructor(
    private val api: BannerService,
) {
    suspend fun getAllPeliFromApi(): MovieMasterResponse {
        Log.d("josue", "getAllQuotesFromApi: ")
        val response: MovieMasterResponse = api.getPeli()
        return response
    }
}