package com.itbproject.savethecat.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressDto(
    @SerialName("street") var street: String,
    @SerialName("suite") var suite: String,
    @SerialName("city") var city: String,
    @SerialName("zipcode") var zipcode: String,
    @SerialName("geo") var geo: GeoDto
)