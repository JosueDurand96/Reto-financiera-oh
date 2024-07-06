package com.durand.retofinancieraoh.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.durand.retofinancieraoh.data.model.MovieMasterResponse
import com.durand.retofinancieraoh.domain.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMovieViewModel @Inject constructor(
    private val getQuotesUseCase: GetMovieUseCase,
) : ViewModel() {

    val quoteModel = MutableLiveData<MovieMasterResponse>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        Log.d("josue", "onCreate: ")
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (result.data.isNotEmpty()) {
                quoteModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

}