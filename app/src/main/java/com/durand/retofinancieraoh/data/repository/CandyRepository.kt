package com.durand.retofinancieraoh.data.repository

import com.durand.retofinancieraoh.data.response.candy.CandyMasterResponse
import com.durand.retofinancieraoh.data.service.BannerService
import javax.inject.Inject

class CandyRepository @Inject constructor(
    private val api: BannerService,
) {

    suspend fun getCandyFromApi(): CandyMasterResponse {
        val response: CandyMasterResponse = api.getCandy()
        return response
    }
}