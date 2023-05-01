package com.itbproject.savethecat.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbproject.savethecat.R
import com.itbproject.savethecat.ui.component.*
import com.itbproject.savethecat.ui.viewmodels.DetailState
import com.itbproject.savethecat.ui.component.LoadIndicator
import com.itbproject.savethecat.ui.models.DetailUiModel

@Composable
fun DetailScreen(
    breedModel: DetailState,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    when(breedModel){
        is DetailState.START, DetailState.LOADING -> LoadIndicator(
            modifier = Modifier
                .fillMaxSize()
        )
        is DetailState.SUCCESS -> {
            LazyColumn(
                modifier = modifier
            ) {
                item {
                    ImageCarousel(
                        images = breedModel.detailState.images,
                        modifier = Modifier
                    )

                    Spacer(
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )
                }

                item {
                    Description(
                        title = breedModel.detailState.name,
                        description = breedModel.detailState.descripcion
                    )

                    Spacer(
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )
                }

                item {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            text = "Country code: " + breedModel.detailState.origin_code,
                            textAlign = TextAlign.Center
                        )

                        Spacer(
                            modifier = Modifier
                                .padding(start = 10.dp, end = 10.dp)
                        )

                        Text(
                            text = "Origin: " + breedModel.detailState.origin,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                    )
                    Divider(
                        thickness = 4.dp
                    )
                }

                items(breedModel.detailState.stats_map.toList().chunked(2)) { items ->
                    VerticalGrid(columnCount = 2, items = items, spacedBy = 16.dp) {
                        StatsDisplayer(
                            text = it.first,
                            statNumber = it.second
                        )
                    }
                }

                item {
                    CatTextButton(
                        text = stringResource(id = R.string.WikipediaText),
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            uriHandler.openUri(breedModel.detailState.wikipedia_url)
                        }
                    )
                }
            }
        }
        is DetailState.FAILURE -> TODO()
    }
}



@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        breedModel = DetailState.SUCCESS(
            DetailUiModel(
                images = emptyList(),
                name = "Preview Cat",
                descripcion = "The preview cat again!!! What a surprise!",
                alt_names = "non",
                origin = "BCN",
                origin_code = "ES",
                life_span = "10",
                wikipedia_url = "",
                stats_map = mapOf(
                    "Preview" to 6,
                    "Almost Preview" to 3
                )
            )
        ))
}