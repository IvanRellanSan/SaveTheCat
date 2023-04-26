package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun <T> VerticalGrid(
    columnCount: Int,
    items: List<T>,
    spacedBy: Dp = 16.dp,
    content: @Composable BoxScope.(T) -> Unit
) {
    Row {
        for ((index, item) in items.withIndex()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f / (columnCount - index))
                    .padding(top = 8.dp, end = if (index % 2 == 0) spacedBy / 2 else 0.dp, start = if (index % 2 == 1) spacedBy / 2 else 0.dp)
            ) {
                content(item)
            }
        }
    }
}
