package com.durand.retofinancieraoh.core

import com.durand.retofinancieraoh.data.network.MovieApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://zaira-tesis.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: MovieApiClient = retrofit.create(MovieApiClient::class.java)
}