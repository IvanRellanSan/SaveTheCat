package com.itbproject.savethecat.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbproject.savethecat.data.models.BreedDto
import com.itbproject.savethecat.data.network.CatApi
import com.itbproject.savethecat.ui.models.BreedUiModel
import com.itbproject.savethecat.ui.models.mapper.BreedDtoToBreedUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class GridViewModel : ViewModel() {
    private val _gridState = MutableStateFlow<List<BreedUiModel>>(mutableListOf())
    val gridState: StateFlow<List<BreedUiModel>> = _gridState.asStateFlow()

    val countryList: MutableList<String> = mutableListOf("ANY")

    var currentCountryCode by mutableStateOf("ANY")
        private set

    init{
        getBreeds()
    }

    private fun getBreeds() {
        viewModelScope.launch {
            try {
                val list = CatApi.retrofitService.getBreeds()
                _gridState.value = BreedDtoToBreedUiModel().map(list)
                if (countryList.size <= 1){
                    for (i in list.indices){

                        if (!countryList.contains(_gridState.value[i].countryCode)){
                            countryList += _gridState.value[i].countryCode
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
        _gridState.value = _gridState.value.sortedBy { it.breedName }
    }

    fun sortByCountry(){
        _gridState.value = _gridState.value.sortedBy { it.origin }
    }

    fun filterByCountry(countryCode: String){
        if (countryCode != currentCountryCode){
            _gridState.value = mutableListOf()
            currentCountryCode = countryCode
            if (countryCode != "ANY"){
                viewModelScope.launch {
                    val filteredList = CatApi.retrofitService.getBreeds().filter { it.country_code == countryCode }

                    if (filteredList.isNotEmpty()){
                        _gridState.value = BreedDtoToBreedUiModel().map(filteredList)
                    }
                }
            }
            else{
                deleteFilter()
            }
        }
    }

    private fun deleteFilter(){
        getBreeds()
    }
}