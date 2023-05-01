package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbproject.savethecat.ui.theme.SaveTheCatTheme

@Composable
fun Description(title: String, description: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = description,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp)
        )

        Divider(
            thickness = 4.dp
        )
    }
}

@Preview
@Composable
fun DescriptionPreview() {
    SaveTheCatTheme {
        Description("Preview title", "This is a preview. You can do nothing with it, but yet you can see it. Curious!")
    }
}
