package com.itbproject.savethecat.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbproject.savethecat.coroutines.AppDispatchers
import com.itbproject.savethecat.data.models.ImageDto
import com.itbproject.savethecat.data.network.CatApi
import com.itbproject.savethecat.data.network.CatApiService
import com.itbproject.savethecat.ui.models.BreedUiModel
import com.itbproject.savethecat.ui.models.DetailUiModel
import com.itbproject.savethecat.ui.models.mapper.BreedDtoToDetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class DetailViewmodel(
    private val apiService: CatApiService = CatApi.retrofitService,
    private val appDispatchers: AppDispatchers = AppDispatchers()
): ViewModel() {
    private val _detailState = MutableStateFlow<DetailState>(DetailState.START)
    val detailState: StateFlow<DetailState> = _detailState.asStateFlow()

    fun loadBreed(id: String){
        if (_detailState.value == DetailState.START){
            _detailState.value = DetailState.LOADING
            viewModelScope.launch {
                try {
                    val breedDetail = withContext(appDispatchers.IO) { apiService.getBreed(id) }
                    val imagesList: List<ImageDto> = withContext(appDispatchers.IO) { apiService.getImages(id, 15) }
                    _detailState.value = DetailState.SUCCESS(BreedDtoToDetailUiState().map(breedDetail, imagesList))
                }
                catch (e: IOException){
                    _detailState.value = DetailState.FAILURE("Error: " + e.message)
                }
            }
        }

    }
}

sealed class DetailState {
    object START : DetailState()
    object LOADING : DetailState()
    data class SUCCESS(val detailState: DetailUiModel) : DetailState()
    data class FAILURE(val message: String) : DetailState()
}