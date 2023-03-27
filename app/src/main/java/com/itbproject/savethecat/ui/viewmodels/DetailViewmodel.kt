package com.itbproject.savethecat.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbproject.savethecat.model.BreedModel
import com.itbproject.savethecat.model.Image
import com.itbproject.savethecat.network.CatApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class DetailViewmodel: ViewModel() {
    private val _detailState = MutableStateFlow<BreedModel?>(null)
    val detailState: StateFlow<BreedModel?> = _detailState.asStateFlow()

    fun loadBreed(id: String){
        viewModelScope.launch {
            try {
                _detailState.value = CatApi.retrofitService.getBreed(id)
                val images: List<Image> = CatApi.retrofitService.getImages(id, 15)
                _detailState.value!!.images = images
            }
            catch (e: IOException){
                Log.d("ERROR", e.toString())
            }
        }
    }
}