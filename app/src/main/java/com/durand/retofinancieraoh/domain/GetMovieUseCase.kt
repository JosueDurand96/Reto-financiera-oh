package com.durand.retofinancieraoh.domain

import com.durand.retofinancieraoh.data.MovieRepository
import com.durand.retofinancieraoh.domain.model.Movie
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(): List<Movie> {
        val quotes = repository.getAllQuotesFromApi()
        return quotes
    }
}