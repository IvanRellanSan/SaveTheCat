package com.itbproject.savethecat.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeoDto(
    @SerialName("lat") val lat: String,
    @SerialName("lng") val lng: String
)