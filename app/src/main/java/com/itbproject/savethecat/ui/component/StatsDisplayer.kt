package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbproject.savethecat.ui.theme.SaveTheCatTheme

@Composable
fun StatsDisplayer(text: String, statNumber: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = text
        )

        Row {
            for (i in 1..statNumber){
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Star")
            }
        }
    }
}

@Preview
@Composable
fun StatsDisplayerPreview() {
    SaveTheCatTheme() {
        StatsDisplayer(text = "Preview", 4)
    }
}