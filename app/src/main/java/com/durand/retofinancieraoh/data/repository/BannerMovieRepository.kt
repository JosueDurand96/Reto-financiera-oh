package com.durand.retofinancieraoh.data.repository

import com.durand.retofinancieraoh.data.service.BannerService
import com.durand.retofinancieraoh.data.response.banner.BannerMovieMasterResponse
import javax.inject.Inject

class BannerMovieRepository @Inject constructor(
    private val api: BannerService,
) {

    suspend fun getAllQuotesFromApi(): BannerMovieMasterResponse {
        val response: BannerMovieMasterResponse = api.getBanner()
        return response
    }
}