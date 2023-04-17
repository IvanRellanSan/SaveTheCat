package com.itbproject.savethecat.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbproject.savethecat.data.models.ImageDto
import com.itbproject.savethecat.data.network.CatApi
import com.itbproject.savethecat.ui.models.DetailUiState
import com.itbproject.savethecat.ui.models.mapper.BreedDtoToDetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class DetailViewmodel: ViewModel() {
    private val _detailState = MutableStateFlow(
        DetailUiState(
            images = mutableListOf(),
            name = "",
            descripcion = "",
            alt_names = "",
            origin = "",
            life_span = "",
            wikipedia_url = "",
            stats_map = mapOf()
        )
    )
    val detailState: StateFlow<DetailUiState> = _detailState.asStateFlow()

    fun loadBreed(id: String){
        viewModelScope.launch {
            try {
                val breedDetail = CatApi.retrofitService.getBreed(id)
                val imagesList: List<ImageDto> = CatApi.retrofitService.getImages(id, 15)
                _detailState.value = BreedDtoToDetailUiState().map(breedDetail, imagesList)
            }
            catch (e: IOException){
                Log.d("ERROR", e.toString())
            }
        }
    }
}