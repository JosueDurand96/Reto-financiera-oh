package com.durand.retofinancieraoh.data

import android.util.Log
import com.durand.retofinancieraoh.data.network.MovieService
import com.durand.retofinancieraoh.data.model.MovieModel
import com.durand.retofinancieraoh.domain.model.Movie
import javax.inject.Inject
import com.durand.retofinancieraoh.domain.model.toDomain

class MovieRepository @Inject constructor(
    private val api: MovieService,
) {
    suspend fun getAllQuotesFromApi(): List<Movie> {
        Log.d("josue", "getAllQuotesFromApi: ")
        val response: List<MovieModel> = api.getMovie()
        return response.map { it.toDomain() }
    }

}