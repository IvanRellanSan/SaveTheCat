package com.itbproject.savethecat.ui.models.mapper

import com.itbproject.savethecat.data.models.BreedDto
import com.itbproject.savethecat.ui.models.BreedUiModel

class BreedDtoToBreedUiModel {
    fun map(list: List<BreedDto>?): List<BreedUiModel> {

        return list?.map {
            BreedUiModel(
                id = it.id,
                breedName = it.name,
                breedDescription = it.description,
                breedImageUrl = it.image?.url,
                origin = it.origin,
                countryCode = it.country_code
            )
        } ?: emptyList()
    }
}