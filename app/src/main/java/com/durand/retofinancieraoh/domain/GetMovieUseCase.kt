package com.durand.retofinancieraoh.domain

import androidx.lifecycle.LiveData
import com.durand.retofinancieraoh.data.model.MovieResponse
import com.durand.retofinancieraoh.data.repository.MovieRepository
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(): LiveData<MovieResponse> {
        val quotes = repository.getAllQuotesFromApi()
        return quotes
    }
}