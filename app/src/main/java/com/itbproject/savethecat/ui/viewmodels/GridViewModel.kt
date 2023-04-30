package com.itbproject.savethecat.ui.viewmodels

import android.os.Debug
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbproject.savethecat.data.models.BreedDto
import com.itbproject.savethecat.data.network.CatApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class GridViewModel : ViewModel() {
    private val _gridState = MutableStateFlow<List<BreedDto>>(mutableListOf())
    val gridState: StateFlow<List<BreedDto>> = _gridState.asStateFlow()

    val countryList: MutableList<String> = mutableListOf("ANY")

    init{
        getBreeds()
    }

    private fun getBreeds() {
        viewModelScope.launch {
            try {
                _gridState.value = CatApi.retrofitService.getBreeds()
                if (countryList.size <= 1){
                    for (i in 0 until _gridState.value.size){
                        if (!countryList.contains(_gridState.value[i].country_code!!)){
                            countryList += _gridState.value[i].country_code!!
                        }
                    }
                }
            }
            catch (e: IOException){
                Log.d("ERROR", e.toString())
            }
        }
    }

    fun sortByName(){
        _gridState.value = _gridState.value.sortedBy { it.name }
    }

    fun sortByCountry(){
        _gridState.value = _gridState.value.sortedBy { it.origin }
    }

    fun filterByCountry(countryCode: String){
        if (countryCode != "ANY"){
            viewModelScope.launch {
                _gridState.value = CatApi.retrofitService.getBreeds()
                val filteredList = _gridState.value.filter { it.country_code == countryCode }

                if (filteredList.isNotEmpty()){
                    _gridState.value = filteredList
                }
            }
        }
        else{
            deleteFilter()
        }
    }

    private fun deleteFilter(){
        getBreeds()
    }
}