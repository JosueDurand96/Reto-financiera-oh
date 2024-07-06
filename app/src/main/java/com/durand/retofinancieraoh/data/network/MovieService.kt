package com.durand.retofinancieraoh.data.network

import com.durand.retofinancieraoh.data.model.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val api: MovieApiClient) {

    suspend fun getMovie(): List<MovieModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllMovie()
            response.body() ?: emptyList()
        }
    }
}