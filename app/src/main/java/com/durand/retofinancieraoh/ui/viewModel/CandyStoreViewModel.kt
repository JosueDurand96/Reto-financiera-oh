package com.durand.retofinancieraoh.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.durand.retofinancieraoh.data.response.candy.CandyMasterResponse
import com.durand.retofinancieraoh.domain.GetCandyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CandyStoreViewModel @Inject constructor(
    private val getCandyUseCase: GetCandyUseCase,
) : ViewModel() {

    val candyModel = MutableLiveData<CandyMasterResponse>()
    val isLoading = MutableLiveData<Boolean>()

    fun showCandyStore() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCandyUseCase()
            if (result.data.isNotEmpty()) {
                candyModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}