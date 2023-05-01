package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadIndicator(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ){
        CircularProgressIndicator(
            strokeWidth = 6.dp
        )
    }
}

@Preview
@Composable
fun LoadIndicatorPreview() {
    LoadIndicator()
}