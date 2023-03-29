package com.itbproject.savethecat.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbproject.savethecat.data.models.BreedModel
import com.itbproject.savethecat.data.network.CatApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class GridViewModel : ViewModel() {
    private val _gridState = MutableStateFlow<List<BreedModel>>(mutableListOf())
    val gridState: StateFlow<List<BreedModel>> = _gridState.asStateFlow()

    fun getBreeds() {
        viewModelScope.launch {
            try {
                _gridState.value = CatApi.retrofitService.getBreeds()
            }
            catch (e: IOException){
                Log.d("ERROR", e.toString())
            }
        }
    }
}