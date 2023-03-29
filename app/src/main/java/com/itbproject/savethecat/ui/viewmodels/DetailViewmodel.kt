package com.itbproject.savethecat.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbproject.savethecat.data.models.BreedModel
import com.itbproject.savethecat.data.models.Image
import com.itbproject.savethecat.data.network.CatApi
import com.itbproject.savethecat.ui.states.DetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class DetailViewmodel: ViewModel() {
    private val _detailState = MutableStateFlow<DetailUiState?>(null)
    val detailState: StateFlow<DetailUiState?> = _detailState.asStateFlow()

    fun loadBreed(id: String){
        viewModelScope.launch {
            try {
                val breedDetail = CatApi.retrofitService.getBreed(id)
                val imagesList: List<Image> = CatApi.retrofitService.getImages(id, 15)
                val urlsList: List<String>
                _detailState.value = DetailUiState(
                    images = mutableListOf<String>().apply {
                        imagesList.forEach {
                            this.add(it.url!!)
                        }
                    },
                    name = breedDetail.name!!,
                    descripcion = breedDetail.description!!,
                    alt_names = breedDetail.alt_names!!,
                    origin = breedDetail.origin!!,
                    life_span = breedDetail.life_span!!,
                    wikipedia_url = breedDetail.wikipedia_url!!,
                    stats_map = mapOf(
                        "Affection Level" to breedDetail.affection_level!!,
                        "Adaptability" to breedDetail.adaptability!!,
                        "Child Friendly" to breedDetail.child_friendly!!,
                        "Dog Friendly" to breedDetail.dog_friendly!!,
                        "Energy Level" to breedDetail.energy_level!!,
                        "Grooming" to breedDetail.grooming!!,
                        "Health Issues" to breedDetail.health_issues!!,
                        "Intelligence" to breedDetail.intelligence!!,
                        "Sheeding Level" to breedDetail.shedding_level!!,
                        "Social Needs" to breedDetail.social_needs!!,
                        "Stranger Friendly" to breedDetail.stranger_friendly!!,
                        "Vocalisation" to breedDetail.vocalisation!!
                    )
                )
            }
            catch (e: IOException){
                Log.d("ERROR", e.toString())
            }
        }
    }
}