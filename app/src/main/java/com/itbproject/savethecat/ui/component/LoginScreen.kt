package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbproject.savethecat.R

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.savethecat_logo),
            contentDescription = "Our logo",
            modifier = Modifier
                .size(200.dp))

        Spacer(
            modifier = Modifier
                .padding(top = 5.dp)
        )

        InputField(
            title = "Name"
        )

        Spacer(
            modifier = Modifier
                .padding(top = 15.dp)
        )

        InputField(
            title = "Password"
        )

        Spacer(
            modifier = Modifier
                .padding(top = 15.dp)
        )

        CatButton(
            text = "Sign in",
            modifier = Modifier
                .size(width = 150.dp, height = 40.dp)
        )

        CatTextButton(
            onClick = { },
            text = "Don't have an account? Click here",
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    Surface {
        LoginScreen()
    }
}