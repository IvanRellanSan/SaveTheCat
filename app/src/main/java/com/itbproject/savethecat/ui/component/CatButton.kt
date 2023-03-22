package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CatButton(modifier: Modifier = Modifier, text: String) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier,
        shape = RoundedCornerShape(50)
    ) {
        Text(
            text = text
        )
    }
}

@Preview
@Composable
fun CatButtonPreview() {
    CatButton(text = "Preview")
}