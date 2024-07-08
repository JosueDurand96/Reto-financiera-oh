package com.durand.retofinancieraoh.domain

import com.durand.retofinancieraoh.data.repository.CandyRepository
import com.durand.retofinancieraoh.data.response.candy.CandyMasterResponse
import javax.inject.Inject

class GetCandyUseCase @Inject constructor(private val repository: CandyRepository) {

    suspend operator fun invoke(): CandyMasterResponse {
        val candy = repository.getCandyFromApi()
        return candy
    }
}