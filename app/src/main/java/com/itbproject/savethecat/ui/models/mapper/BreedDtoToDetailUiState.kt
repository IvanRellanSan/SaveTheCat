package com.itbproject.savethecat.ui.models.mapper

import androidx.compose.ui.res.stringResource
import com.itbproject.savethecat.R
import com.itbproject.savethecat.data.models.BreedDto
import com.itbproject.savethecat.data.models.ImageDto
import com.itbproject.savethecat.ui.models.DetailUiModel

class BreedDtoToDetailUiState {
    fun map(breedDto: BreedDto, imageList: List<ImageDto>? = null) : DetailUiModel{
        return DetailUiModel(
            images = mutableListOf<String>().apply {
                imageList.let { list ->
                    list?.forEach {
                        add(it.url)
                    }
                }
            },
            name = breedDto.name,
            descripcion = breedDto.description,
            alt_names = breedDto.alt_names ?: "UNKNOWN",
            origin = breedDto.origin,
            origin_code = breedDto.country_code,
            life_span = breedDto.life_span,
            wikipedia_url = breedDto.wikipedia_url ?: "https://en.wikipedia.org/wiki/HTTP_404",
            stats_map = mapOf(
                "Affection Level" to breedDto.affection_level,
                "Adaptability" to breedDto.adaptability,
                "Child Friendly" to breedDto.child_friendly,
                "Dog Friendly" to breedDto.dog_friendly,
                "Energy Level" to breedDto.energy_level,
                "Grooming" to breedDto.grooming,
                "Health Issues" to breedDto.health_issues,
                "Intelligence" to breedDto.intelligence,
                "Sheeding Level" to breedDto.shedding_level,
                "Social Needs" to breedDto.social_needs,
                "Stranger Friendly" to breedDto.stranger_friendly,
                "Vocalisation" to breedDto.vocalisation
            )
        )
    }
}