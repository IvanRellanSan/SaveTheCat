package com.itbproject.savethecat.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itbproject.savethecat.R
import com.itbproject.savethecat.navigation.MainNavigator
import com.itbproject.savethecat.ui.component.CatButton
import com.itbproject.savethecat.ui.component.CatTextButton
import com.itbproject.savethecat.ui.component.InputField
import com.itbproject.savethecat.ui.models.LoginUiModel
import com.itbproject.savethecat.ui.viewmodels.MainViewmodel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSignInClick: (LoginUiModel) -> Unit,
    viewmodel: MainViewmodel = viewModel()
) {
    val context = LocalContext.current

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
            title = "Name",
            value = viewmodel.userName,
            updateValue = { viewmodel.updateUsername(it) },
            showValue = true
        )

        Spacer(
            modifier = Modifier
                .padding(top = 15.dp)
        )

        InputField(
            title = "Password",
            value = viewmodel.password,
            updateValue = { viewmodel.updatePassword(it) },
            showValue = false
        )

        Spacer(
            modifier = Modifier
                .padding(top = 15.dp)
        )

        CatButton(
            text = "Sign in",
            action = { MainNavigator().goToGridActivity(context = context) },
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
        LoginScreen(onSignInClick = { })
    }
}