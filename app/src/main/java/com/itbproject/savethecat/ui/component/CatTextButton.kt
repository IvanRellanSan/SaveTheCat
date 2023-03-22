package com.itbproject.savethecat.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.TextButton
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CatTextButton(modifier: Modifier = Modifier, text: String) {
    TextButton(
        modifier = modifier,
        onClick = { /*TODO*/ }
    ) {
        Text(
            text = text
        )
    }
}

@Preview
@Composable
fun CatTextButtonPreview() {
    CatTextButton(text = "Is this a preview? Don't click this")
}