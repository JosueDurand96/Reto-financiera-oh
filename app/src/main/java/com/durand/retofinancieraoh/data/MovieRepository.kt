package com.durand.retofinancieraoh.data

import android.util.Log
import com.durand.retofinancieraoh.data.model.MovieMasterResponse
import com.durand.retofinancieraoh.data.network.MovieService
import com.durand.retofinancieraoh.data.model.MovieResponse
import javax.inject.Inject
import com.durand.retofinancieraoh.domain.model.toDomain

class MovieRepository @Inject constructor(
    private val api: MovieService,
) {
    suspend fun getAllQuotesFromApi(): MovieMasterResponse {
        Log.d("josue", "getAllQuotesFromApi: ")
        val response: MovieMasterResponse = api.getMovie()
        return response
    }

}