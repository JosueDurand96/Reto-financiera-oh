package com.durand.retofinancieraoh.domain

import com.durand.retofinancieraoh.data.repository.MovieRepository
import com.durand.retofinancieraoh.data.response.peli.MovieMasterResponse
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(): MovieMasterResponse {
        val movie = repository.getAllMovieFromApi()
        return movie
    }
}