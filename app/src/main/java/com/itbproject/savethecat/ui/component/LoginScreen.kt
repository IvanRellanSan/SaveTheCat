package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        InputField(title = "Name")

        Spacer(
            modifier = Modifier
                .padding(top = 20.dp)
        )

        InputField(title = "Password")
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}