package com.durand.retofinancieraoh.data.service

import com.durand.retofinancieraoh.data.network.MovieApiClient
import com.durand.retofinancieraoh.data.response.banner.BannerMovieMasterResponse
import com.durand.retofinancieraoh.data.response.peli.MovieMasterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BannerService @Inject constructor(private val api: MovieApiClient) {

    suspend fun getMovie(): BannerMovieMasterResponse {
        return withContext(Dispatchers.IO) {
            val response = api.getAllMovie()
            return@withContext response.body()!!
        }
    }

    suspend fun getPeli(): MovieMasterResponse {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPelis()
            return@withContext response.body()!!
        }
    }

}