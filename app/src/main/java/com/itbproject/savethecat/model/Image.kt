package com.itbproject.savethecat.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName(value = "height") val height: Int? = null,
    @SerialName(value = "id") val id: String? = null,
    @SerialName(value = "url") val url: String? = null,
    @SerialName(value = "width") val width: Int? = null
)