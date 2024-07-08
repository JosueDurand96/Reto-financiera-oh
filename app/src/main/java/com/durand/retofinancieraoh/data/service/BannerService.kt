package com.durand.retofinancieraoh.data.service

import com.durand.retofinancieraoh.data.network.MovieApiClient
import com.durand.retofinancieraoh.data.response.banner.BannerMovieMasterResponse
import com.durand.retofinancieraoh.data.response.candy.CandyMasterResponse
import com.durand.retofinancieraoh.data.response.peli.MovieMasterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BannerService @Inject constructor(private val api: MovieApiClient) {

    suspend fun getBanner(): BannerMovieMasterResponse {
        return withContext(Dispatchers.IO) {
            val response = api.getAllBanner()
            return@withContext response.body()!!
        }
    }

    suspend fun getMovie(): MovieMasterResponse {
        return withContext(Dispatchers.IO) {
            val response = api.getAllMovie()
            return@withContext response.body()!!
        }
    }

    suspend fun getCandy(): CandyMasterResponse {
        return withContext(Dispatchers.IO) {
            val response = api.getCandy()
            return@withContext response.body()!!
        }
    }
}