package com.itbproject.savethecat.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BreedDto(
    @SerialName(value = "adaptability") val adaptability: Int? = null,
    @SerialName(value = "affection_level") val affection_level: Int? = null,
    @SerialName(value = "alt_names") val alt_names: String? = null,
    @SerialName(value = "cfa_url") val cfa_url: String? = null,
    @SerialName(value = "child_friendly") val child_friendly: Int? = null,
    @SerialName(value = "cat_friendly") val cat_friendly: Int? = null,
    @SerialName(value = "bidability") val bidability: Int? = null,
    @SerialName(value = "country_code") val country_code: String? = null,
    @SerialName(value = "country_codes") val country_codes: String? = null,
    @SerialName(value = "description") val description: String? = null,
    @SerialName(value = "dog_friendly") val dog_friendly: Int? = null,
    @SerialName(value = "energy_level") val energy_level: Int? = null,
    @SerialName(value = "experimental") val experimental: Int? = null,
    @SerialName(value = "grooming") val grooming: Int? = null,
    @SerialName(value = "hairless") val hairless: Int? = null,
    @SerialName(value = "health_issues") val health_issues: Int? = null,
    @SerialName(value = "hypoallergenic") val hypoallergenic: Int? = null,
    @SerialName(value = "id") val id: String? = null,
    @SerialName(value = "image") val image: ImageDto? = null,
    @SerialName(value = "indoor") val indoor: Int? = null,
    @SerialName(value = "intelligence") val intelligence: Int? = null,
    @SerialName(value = "lap") val lap: Int? = null,
    @SerialName(value = "life_span") val life_span: String? = null,
    @SerialName(value = "name") val name: String? = null,
    @SerialName(value = "natural") val natural: Int? = null,
    @SerialName(value = "origin") val origin: String? = null,
    @SerialName(value = "rare") val rare: Int? = null,
    @SerialName(value = "reference_image_id") val reference_image_id: String? = null,
    @SerialName(value = "rex") val rex: Int? = null,
    @SerialName(value = "shedding_level") val shedding_level: Int? = null,
    @SerialName(value = "short_legs") val short_legs: Int? = null,
    @SerialName(value = "social_needs") val social_needs: Int? = null,
    @SerialName(value = "stranger_friendly") val stranger_friendly: Int? = null,
    @SerialName(value = "suppressed_tail") val suppressed_tail: Int? = null,
    @SerialName(value = "temperament") val temperament: String? = null,
    @SerialName(value = "vcahospitals_url") val vcahospitals_url: String? = null,
    @SerialName(value = "vetstreet_url") val vetstreet_url: String? = null,
    @SerialName(value = "vocalisation") val vocalisation: Int? = null,
    @SerialName(value = "weight") val weight: WeightDto? = null,
    @SerialName(value = "wikipedia_url") val wikipedia_url: String? = null
)