package com.durand.retofinancieraoh.domain

import com.durand.retofinancieraoh.data.MovieRepository
import com.durand.retofinancieraoh.data.model.MovieMasterResponse
import com.durand.retofinancieraoh.data.model.MovieResponse
import com.durand.retofinancieraoh.domain.model.Movie
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(): MovieMasterResponse {
        val quotes = repository.getAllQuotesFromApi()
        return quotes
    }
}