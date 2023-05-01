package com.itbproject.savethecat.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeightDto(
    @SerialName(value = "imperial") val imperial: String,
    @SerialName(value = "metric") val metric: String
)