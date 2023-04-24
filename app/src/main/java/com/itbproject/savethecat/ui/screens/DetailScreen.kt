package com.itbproject.savethecat.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbproject.savethecat.ui.component.*
import com.itbproject.savethecat.ui.models.DetailUiState

@Composable
fun DetailScreen(
    breedModel: DetailUiState,
    modifier: Modifier = Modifier
){
    val scaffoldState = rememberScaffoldState()

    var webOpened by remember{
        mutableStateOf(false)
    }

    Scaffold(
        modifier = modifier,
//        scaffoldState = scaffoldState,
//        topBar = {
//            TopBar()
//        }
    ) {
        LazyColumn{
            item {
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

                Row {
                    Text(
                        text = "Country code: " + breedModel.origin_code
                    )
                }

                CatTextButton(
                    onClick = {
                    },
                    text = "See on wikipedia!"
                )


            }
        }

//        Column (
//            modifier = Modifier
//                .fillMaxSize()
//        ){
//            breedModel.let {
//                ImageCarousel(
//                    images = breedModel.images,
//                    modifier = Modifier
//                )
//
//                Spacer(
//                    modifier = Modifier
//                        .padding(top = 10.dp)
//                )
//
//                Description(
//                    title = breedModel.name,
//                    description = breedModel.descripcion
//                )
//
//                Spacer(
//                    modifier = Modifier
//                        .padding(top = 10.dp)
//                )
//
//                StatsGrid(
//                    mapOfStats = breedModel.stats_map,
//                    modifier = Modifier
//                        .align(Alignment.CenterHorizontally)
//                )
//            }
//        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {

}