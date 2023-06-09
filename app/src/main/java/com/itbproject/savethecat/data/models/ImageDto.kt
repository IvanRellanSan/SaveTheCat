package com.itbproject.savethecat.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageDto(
    @SerialName(value = "breeds") val breeds: List<BreedDto>? = null,
    @SerialName(value = "height") val height: Int,
    @SerialName(value = "id") val id: String,
    @SerialName(value = "url") val url: String,
    @SerialName(value = "width") val width: Int
)