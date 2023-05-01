package com.itbproject.savethecat.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbproject.savethecat.coroutines.AppDispatchers
import com.itbproject.savethecat.data.network.CatApi
import com.itbproject.savethecat.data.network.CatApiService
import com.itbproject.savethecat.ui.models.BreedUiModel
import com.itbproject.savethecat.ui.models.mapper.BreedDtoToBreedUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class GridViewModel(
    private val apiService: CatApiService = CatApi.retrofitService,
    private val appDispatchers: AppDispatchers = AppDispatchers()
) : ViewModel() {
    private val _gridState = MutableStateFlow<GridState>(GridState.START)
    val gridState: StateFlow<GridState> = _gridState.asStateFlow()

    val countryList: MutableList<String> = mutableListOf("ANY")

    var currentCountryCode by mutableStateOf("ANY")
        private set

    init{
        getBreeds()
    }

    private fun getBreeds() {
        viewModelScope.launch {
            _gridState.value = GridState.LOADING
            try {
                val list = withContext(appDispatchers.IO) {
                    apiService.getBreeds()
                }

                _gridState.value = GridState.SUCCESS(BreedDtoToBreedUiModel().map(list))

                if (_gridState.value != GridState.LOADING && countryList.size <= 1){
                    for (i in (_gridState.value as GridState.SUCCESS).gridState.indices){

                        if (!countryList.contains((_gridState.value as GridState.SUCCESS).gridState[i].countryCode)){
                            countryList += (_gridState.value as GridState.SUCCESS).gridState[i].countryCode
                        }
                    }
                }
            }
            catch (e: IOException){
                _gridState.value = GridState.FAILURE(e.localizedMessage!!)
            }
        }
    }

    fun sortByName(){
        _gridState.value = GridState.LOADING
        _gridState.value = GridState.SUCCESS((_gridState.value as GridState.SUCCESS).gridState.sortedBy { it.breedName })
    }

    fun sortByCountry(){
        _gridState.value = GridState.LOADING
        _gridState.value = GridState.SUCCESS((_gridState.value as GridState.SUCCESS).gridState.sortedBy { it.origin })
    }

    fun filterByCountry(countryCode: String){
        if (countryCode != currentCountryCode){
            _gridState.value = GridState.LOADING
            currentCountryCode = countryCode
            if (countryCode != "ANY"){
                viewModelScope.launch {
                    val filteredList = apiService.getBreeds().filter { it.country_code == countryCode }

                    if (filteredList.isNotEmpty()){
                        _gridState.value = GridState.SUCCESS(BreedDtoToBreedUiModel().map(filteredList))
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

sealed class GridState {
    object START : GridState()
    object LOADING : GridState()
    data class SUCCESS(val gridState: List<BreedUiModel>) : GridState()
    data class FAILURE(val message: String) : GridState()
}