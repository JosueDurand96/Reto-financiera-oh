package com.durand.retofinancieraoh.domain

import com.durand.retofinancieraoh.data.repository.PeliRepository
import com.durand.retofinancieraoh.data.response.peli.MovieMasterResponse
import javax.inject.Inject

class GetPeliUseCase @Inject constructor(private val repository: PeliRepository) {

    suspend operator fun invoke(): MovieMasterResponse {
        val peli = repository.getAllPeliFromApi()
        return peli
    }
}