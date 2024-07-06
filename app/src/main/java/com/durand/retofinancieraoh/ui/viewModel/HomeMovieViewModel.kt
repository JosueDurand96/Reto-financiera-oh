package com.durand.retofinancieraoh.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.durand.retofinancieraoh.domain.GetMovieUseCase
import com.durand.retofinancieraoh.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMovieViewModel @Inject constructor(
    private val getQuotesUseCase: GetMovieUseCase,
) : ViewModel() {

    val quoteModel = MutableLiveData<Movie>()
    val isLoading = MutableLiveData<Boolean>()


    fun onCreate() {

            viewModelScope.launch {
                isLoading.postValue(true)
                val result = getQuotesUseCase()
                if (!result.isNullOrEmpty()) {
                    quoteModel.postValue(result[0])
                    isLoading.postValue(false)
                }
            }

    }

}