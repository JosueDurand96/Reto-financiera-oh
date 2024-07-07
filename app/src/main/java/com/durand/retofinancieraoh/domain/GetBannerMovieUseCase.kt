package com.durand.retofinancieraoh.domain

import com.durand.retofinancieraoh.data.repository.BannerMovieRepository
import com.durand.retofinancieraoh.data.response.banner.BannerMovieMasterResponse
import javax.inject.Inject

class GetBannerMovieUseCase @Inject constructor(private val repository: BannerMovieRepository) {

    suspend operator fun invoke(): BannerMovieMasterResponse {
        val quotes = repository.getAllQuotesFromApi()
        return quotes
    }
}