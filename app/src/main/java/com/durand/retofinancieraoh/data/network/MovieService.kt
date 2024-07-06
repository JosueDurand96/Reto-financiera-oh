package com.durand.retofinancieraoh.data.network

import com.durand.retofinancieraoh.data.model.MovieMasterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val api: MovieApiClient) {

    suspend fun getMovie(): MovieMasterResponse {
        return withContext(Dispatchers.IO) {
            val response = api.getAllMovie()
            return@withContext response.body()!!
        }
    }
}