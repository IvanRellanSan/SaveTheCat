package com.itbproject.savethecat.ui.states

data class DetailUiState (
    val images: List<String>,
    val name: String,
    val descripcion: String,
    val alt_names: String,
    val origin: String,
    val life_span: String,
    val wikipedia_url: String,
    val stats_map: Map<String, Int>
)