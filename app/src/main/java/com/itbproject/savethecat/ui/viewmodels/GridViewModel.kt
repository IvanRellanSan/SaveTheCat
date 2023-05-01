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
    private val _gridState = MutableStateFlow<State>(State.START)
    val gridState: StateFlow<State> = _gridState.asStateFlow()

    val countryList: MutableList<String> = mutableListOf("ANY")

    var currentCountryCode by mutableStateOf("ANY")
        private set

    init{
        getBreeds()
    }

    private fun getBreeds() {
        _gridState.value = State.LOADING
        viewModelScope.launch {
            try {
                val list = CatApi.retrofitService.getBreeds()
                val newList = BreedDtoToBreedUiModel().map(list)

                _gridState.value = State.SUCCESS(newList)

                if (countryList.size <= 1){
                    for (i in list.indices){

                        if (!countryList.contains((_gridState.value as State.SUCCESS).gridState[i].countryCode)){
                            countryList += (_gridState.value as State.SUCCESS).gridState[i].countryCode
                        }
                    }
                }
            }
            catch (e: IOException){
                _gridState.value = State.FAILURE("")
            }
        }
    }

    fun sortByName(){
        _gridState.value = State.LOADING
        _gridState.value = State.SUCCESS((_gridState.value as State.SUCCESS).gridState.sortedBy { it.breedName })
    }

    fun sortByCountry(){
        _gridState.value = State.LOADING
        _gridState.value = State.SUCCESS((_gridState.value as State.SUCCESS).gridState.sortedBy { it.origin })
    }

    fun filterByCountry(countryCode: String){
        if (countryCode != currentCountryCode){
            _gridState.value = State.LOADING
            currentCountryCode = countryCode
            if (countryCode != "ANY"){
                viewModelScope.launch {
                    val filteredList = CatApi.retrofitService.getBreeds().filter { it.country_code == countryCode }

                    if (filteredList.isNotEmpty()){
                        _gridState.value = State.SUCCESS(BreedDtoToBreedUiModel().map(filteredList))
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

sealed class State {
    object START : State()
    object LOADING : State()
    data class SUCCESS(val gridState: List<BreedUiModel>) : State()
    data class FAILURE(val message: String) : State()
}