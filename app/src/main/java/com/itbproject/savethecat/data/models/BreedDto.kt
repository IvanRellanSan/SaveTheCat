package com.itbproject.savethecat.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BreedDto(
    @SerialName(value = "adaptability") val adaptability: Int,
    @SerialName(value = "affection_level") val affection_level: Int,
    @SerialName(value = "alt_names") val alt_names: String? = null,
    @SerialName(value = "cfa_url") val cfa_url: String? = null,
    @SerialName(value = "child_friendly") val child_friendly: Int,
    @SerialName(value = "cat_friendly") val cat_friendly: Int? = null,
    @SerialName(value = "bidability") val bidability: Int? = null,
    @SerialName(value = "country_code") val country_code: String,
    @SerialName(value = "country_codes") val country_codes: String,
    @SerialName(value = "description") val description: String,
    @SerialName(value = "dog_friendly") val dog_friendly: Int,
    @SerialName(value = "energy_level") val energy_level: Int,
    @SerialName(value = "experimental") val experimental: Int,
    @SerialName(value = "grooming") val grooming: Int,
    @SerialName(value = "hairless") val hairless: Int,
    @SerialName(value = "health_issues") val health_issues: Int,
    @SerialName(value = "hypoallergenic") val hypoallergenic: Int,
    @SerialName(value = "id") val id: String,
    @SerialName(value = "image") val image: ImageDto? = null,
    @SerialName(value = "indoor") val indoor: Int,
    @SerialName(value = "intelligence") val intelligence: Int,
    @SerialName(value = "lap") val lap: Int? = null,
    @SerialName(value = "life_span") val life_span: String,
    @SerialName(value = "name") val name: String,
    @SerialName(value = "natural") val natural: Int,
    @SerialName(value = "origin") val origin: String,
    @SerialName(value = "rare") val rare: Int,
    @SerialName(value = "reference_image_id") val reference_image_id: String? = null,
    @SerialName(value = "rex") val rex: Int,
    @SerialName(value = "shedding_level") val shedding_level: Int,
    @SerialName(value = "short_legs") val short_legs: Int,
    @SerialName(value = "social_needs") val social_needs: Int,
    @SerialName(value = "stranger_friendly") val stranger_friendly: Int,
    @SerialName(value = "suppressed_tail") val suppressed_tail: Int,
    @SerialName(value = "temperament") val temperament: String,
    @SerialName(value = "vcahospitals_url") val vcahospitals_url: String? = null,
    @SerialName(value = "vetstreet_url") val vetstreet_url: String? = null,
    @SerialName(value = "vocalisation") val vocalisation: Int,
    @SerialName(value = "weight") val weight: WeightDto,
    @SerialName(value = "wikipedia_url") val wikipedia_url: String? = null
)