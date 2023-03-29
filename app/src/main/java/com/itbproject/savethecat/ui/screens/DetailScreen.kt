package com.itbproject.savethecat.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbproject.savethecat.ui.component.Description
import com.itbproject.savethecat.ui.component.ImageCarousel
import com.itbproject.savethecat.ui.component.TopBar
import com.itbproject.savethecat.ui.states.DetailUiState

@Composable
fun DetailScreen(breedModel: DetailUiState, modifier: Modifier = Modifier) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            TopBar()
        }
    ) {
        breedModel.let {
            ImageCarousel(
                images = breedModel.images,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(
                modifier = Modifier
                    .padding(top = 10.dp)
            )

            Description(
                title = breedModel.name,
                description = breedModel.descripcion
            )
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {

}