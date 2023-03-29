package com.itbproject.savethecat.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Weight(
    @SerialName(value = "imperial") val imperial: String? = null,
    @SerialName(value = "metric") val metric: String? = null
)