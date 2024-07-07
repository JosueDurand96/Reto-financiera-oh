package com.durand.retofinancieraoh.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.durand.retofinancieraoh.data.model.MovieResponse
import com.durand.retofinancieraoh.data.repository.MovieRepository
import com.durand.retofinancieraoh.data.response.banner.BannerMovieMasterResponse
import com.durand.retofinancieraoh.data.response.peli.MovieMasterResponse
import com.durand.retofinancieraoh.domain.GetBannerMovieUseCase
import com.durand.retofinancieraoh.domain.GetMovieUseCase
import com.durand.retofinancieraoh.domain.GetPeliUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMovieViewModel @Inject constructor(
    private val getBannerMovieUseCase: GetBannerMovieUseCase,
    private val getPeliUseCase: GetPeliUseCase,
) : ViewModel() {

    val bannerModel = MutableLiveData<BannerMovieMasterResponse>()
    val movieModel = MutableLiveData<MovieMasterResponse>()
    val isLoading = MutableLiveData<Boolean>()

    fun showBanner() {
        Log.d("josue", "showBanner: ")
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getBannerMovieUseCase()
            if (result.data.isNotEmpty()) {
                bannerModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun showPeli() {
        Log.d("josue", "showPeli: ")
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPeliUseCase()
            if (result.data.isNotEmpty()) {
                movieModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }


}