package com.itbproject.savethecat.ui.models

data class DetailUiState (
    val images: List<String>,
    val name: String,
    val descripcion: String,
    val alt_names: String,
    val origin: String,
    val origin_code: String,
    val life_span: String,
    val wikipedia_url: String,
    val stats_map: Map<String, Int>
)