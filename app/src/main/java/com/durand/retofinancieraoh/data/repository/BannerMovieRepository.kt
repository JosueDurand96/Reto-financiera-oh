package com.durand.retofinancieraoh.data.repository

import android.util.Log
import com.durand.retofinancieraoh.data.service.BannerService
import com.durand.retofinancieraoh.data.response.banner.BannerMovieMasterResponse
import javax.inject.Inject

class BannerMovieRepository @Inject constructor(
    private val api: BannerService,
) {
    suspend fun getAllQuotesFromApi(): BannerMovieMasterResponse {
        Log.d("josue", "getAllQuotesFromApi: ")
        val response: BannerMovieMasterResponse = api.getMovie()
        return response
    }
}