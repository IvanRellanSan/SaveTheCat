package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StatsGrid(mapOfStats: Map<String, Int>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2)
    ){
        items(
            items = mapOfStats.toList(),
            itemContent = {
                StatsDisplayer(
                    text = it.first,
                    statNumber = it.second,
                    modifier = Modifier
                )
            }
        )
    }
}

@Preview
@Composable
fun StatsGridPreview() {
    val statsMap: Map<String, Int> = mapOf(
        "Affection Level" to 5,
        "Adaptability" to 4,
        "Child Friendly" to 3,
        "Dog Friendly" to 4,
        "Energy Level" to 1,
        "Grooming" to 2,
        "Health Issues" to 3,
        "Intelligence" to 5,
        "Sheeding Level" to 1,
        "Social Needs" to 1,
        "Stranger Friendly" to 2,
        "Vocalisation" to 5
    )

    StatsGrid(mapOfStats = statsMap)
}