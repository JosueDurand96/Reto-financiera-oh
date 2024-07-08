package com.durand.retofinancieraoh.data.repository

import com.durand.retofinancieraoh.data.response.peli.MovieMasterResponse
import com.durand.retofinancieraoh.data.service.BannerService
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: BannerService,
) {

    suspend fun getAllMovieFromApi(): MovieMasterResponse {
        val response: MovieMasterResponse = api.getMovie()
        return response
    }
}