package com.durand.retofinancieraoh.data.network

import com.durand.retofinancieraoh.data.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiClient {
    @GET("api/movie/getAll")
    suspend fun getAllMovie():Response<List<MovieModel>>

}