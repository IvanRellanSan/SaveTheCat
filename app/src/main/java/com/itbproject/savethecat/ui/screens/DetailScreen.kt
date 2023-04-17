package com.itbproject.savethecat.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbproject.savethecat.ui.component.Description
import com.itbproject.savethecat.ui.component.ImageCarousel
import com.itbproject.savethecat.ui.component.StatsGrid
import com.itbproject.savethecat.ui.component.TopBar
import com.itbproject.savethecat.ui.models.DetailUiState

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
        Column (
            modifier = Modifier
                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
        ){
            breedModel.let {
                ImageCarousel(
                    images = breedModel.images,
                    modifier = Modifier
                )

                Spacer(
                    modifier = Modifier
                        .padding(top = 10.dp)
                )

                Description(
                    title = breedModel.name,
                    description = breedModel.descripcion
                )

                Spacer(
                    modifier = Modifier
                        .padding(top = 10.dp)
                )

                StatsGrid(
                    mapOfStats = breedModel.stats_map,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {

}