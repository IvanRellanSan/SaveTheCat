package com.itbproject.savethecat.ui.models

data class BreedUiModel (
    val id: String,
    val breedName: String,
    val breedDescription: String,
    val breedImageUrl: String? = null,
    val origin: String,
    val countryCode: String
)