package com.durand.retofinancieraoh.data.service

import android.util.Log
import com.durand.retofinancieraoh.data.model.MovieResponse
import com.durand.retofinancieraoh.data.network.TheMovieDBInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import javax.inject.Inject

class MovieService @Inject constructor(private val api: TheMovieDBInterface) {

    suspend fun getMovie(): Call<MovieResponse> {
        Log.d("josue", "MovieService")
        return withContext(Dispatchers.IO) {
            val response = api.getPopularMovie(1)
            return@withContext response
        }
    }
}