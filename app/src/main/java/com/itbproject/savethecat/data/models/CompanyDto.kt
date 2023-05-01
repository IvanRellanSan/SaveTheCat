package com.itbproject.savethecat.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompanyDto(
    @SerialName("bs") val bs: String,
    @SerialName("catchPhrase") val catchPhrase: String,
    @SerialName("name") val name: String
)