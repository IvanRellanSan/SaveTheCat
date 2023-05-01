package com.itbproject.savethecat.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("id") var id: Int,
    @SerialName("name") var name: String,
    @SerialName("username") var username: String,
    @SerialName("email") var email: String,
    @SerialName("address") var address: AddressDto,
    @SerialName("phone") var phone: String,
    @SerialName("website") var website: String,
    @SerialName("company") var company: CompanyDto
)