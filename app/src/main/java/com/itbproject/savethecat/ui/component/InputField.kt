package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbproject.savethecat.ui.theme.Shapes

@Composable
fun InputField(modifier: Modifier = Modifier, title: String) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .padding(start = 20.dp),
            text = title
        )
        TextField(
            value = "",
            onValueChange = { },
            shape = RoundedCornerShape(50),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}

@Preview
@Composable
fun InputFieldPreview() {
    InputField(title = "Preview")
}