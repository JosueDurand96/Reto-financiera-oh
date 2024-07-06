package com.durand.retofinancieraoh.core

import com.durand.retofinancieraoh.data.network.MovieApiClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitHelper {

    val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(1000, TimeUnit.SECONDS)
        .connectTimeout(1000, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://zaira-tesis.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val api: MovieApiClient = retrofit.create(MovieApiClient::class.java)
}