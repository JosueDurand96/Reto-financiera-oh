package com.durand.retofinancieraoh.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.durand.retofinancieraoh.data.model.MovieResponse
import com.durand.retofinancieraoh.data.service.MovieService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: MovieService,
) {

    suspend fun getAllQuotesFromApi(): LiveData<MovieResponse> {
        val data = MutableLiveData<MovieResponse>()

        api.getMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    Log.d("josue", "isSuccessful")
                    data.value = response.body()
                    Log.d("josue", "isSuccessful: " +response.body()!!.results[0].poster_path)

                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("josue", "onFailure")
            }
        })

        return data
    }
}