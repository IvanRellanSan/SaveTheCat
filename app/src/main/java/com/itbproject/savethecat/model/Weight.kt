package com.itbproject.savethecat.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Weight(
    @SerialName(value = "imperial") val imperial: String? = null,
    @SerialName(value = "metric") val metric: String? = null
)