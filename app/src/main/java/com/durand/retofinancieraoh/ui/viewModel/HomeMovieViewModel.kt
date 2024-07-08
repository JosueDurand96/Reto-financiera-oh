package com.durand.retofinancieraoh.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.durand.retofinancieraoh.data.response.banner.BannerMovieMasterResponse
import com.durand.retofinancieraoh.data.response.peli.MovieMasterResponse
import com.durand.retofinancieraoh.domain.GetBannerMovieUseCase
import com.durand.retofinancieraoh.domain.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMovieViewModel @Inject constructor(
    private val getBannerMovieUseCase: GetBannerMovieUseCase,
    private val getMovieUseCase: GetMovieUseCase,
) : ViewModel() {

    val bannerModel = MutableLiveData<BannerMovieMasterResponse>()
    val movieModel = MutableLiveData<MovieMasterResponse>()
    private val isLoading = MutableLiveData<Boolean>()

    fun showBanner() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getBannerMovieUseCase()
            if (result.data.isNotEmpty()) {
                bannerModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun showMovie() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMovieUseCase()
            if (result.data.isNotEmpty()) {
                movieModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}