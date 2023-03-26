package com.itbproject.savethecat.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbproject.savethecat.model.Cat
import androidx.compose.foundation.lazy.items
import com.itbproject.savethecat.data.Datasource
import com.itbproject.savethecat.ui.theme.SaveTheCatTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CatGrid(catList: List<Cat>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = modifier,
        cells = GridCells.Fixed(2)
    ){
        items(
            items = catList,
            itemContent = {
                CatCard(
                    cat = it,
                    modifier = Modifier
                        .animateContentSize(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioLowBouncy,
                                stiffness = Spring.StiffnessLow
                            )
                        )
                )
            }
        )
    }
}

@Preview
@Composable
fun CatGridPreview() {
    val catList = Datasource().loadAffirmations()
    SaveTheCatTheme {
        CatGrid(catList = catList)
    }
}