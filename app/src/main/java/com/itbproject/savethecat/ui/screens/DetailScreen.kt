package com.itbproject.savethecat.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbproject.savethecat.ui.component.*
import com.itbproject.savethecat.ui.models.DetailUiModel
import kotlinx.coroutines.launch

@Composable
fun DetailScreen(
    breedModel: DetailUiModel,
    modifier: Modifier = Modifier
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    var webOpened by remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = modifier,
//        scaffoldState = scaffoldState,
//        topBar = {
//            TopBar()
//        }
    ) {
        LazyColumn {
            item {
                ImageCarousel(
                    images = breedModel.images,
                    modifier = Modifier
                )

                Spacer(
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
            }

            item {
                Description(
                    title = breedModel.name,
                    description = breedModel.descripcion
                )

                Spacer(
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
            }

            item {
                Row {
                    Text(
                        text = "Country code: " + breedModel.origin_code
                    )
                }
            }

            items(breedModel.stats_map.toList().chunked(2)) { items ->
                VerticalGrid(columnCount = 2, items = items, spacedBy = 16.dp) {
                    StatsDisplayer(
                        text = it.first,
                        statNumber = it.second,
                        modifier = Modifier
                    )
                }
            }

            coroutineScope.launch {
                item {
                    WebView(
                        url = breedModel.wikipedia_url
                    )
                }
            }
/*            item{
                VerticalGrid(
                    columnCount = 2,
                    items = breedModel.stats_map.toList()
                ) {
                    Text(text = "Hola")
                    *//*StatsDisplayer(
                        text = it.first,
                        statNumber = it.second,
                        modifier = Modifier
                    )*//*
                }
            }*/
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

@Preview
@Composable
fun DetailScreenPreview() {

}