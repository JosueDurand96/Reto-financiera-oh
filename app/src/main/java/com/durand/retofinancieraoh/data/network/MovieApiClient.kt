package com.durand.retofinancieraoh.data.network

import com.durand.retofinancieraoh.data.response.banner.BannerMovieMasterResponse
import com.durand.retofinancieraoh.data.response.candy.CandyMasterResponse
import com.durand.retofinancieraoh.data.response.peli.MovieMasterResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiClient {
    @GET("api/movie/getAll")
    suspend fun getAllMovie(): Response<BannerMovieMasterResponse>

    @GET("api/peli/getAll")
    suspend fun getAllPelis(): Response<MovieMasterResponse>

    @GET("api/candy/getAll")
    suspend fun getCandy(): Response<CandyMasterResponse>
}