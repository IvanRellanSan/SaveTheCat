package com.itbproject.savethecat.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.itbproject.savethecat.data.models.BreedDto
import com.itbproject.savethecat.navigation.MainNavigator

@Composable
fun CatGrid(catList: List<BreedDto>, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2)
    ){
        items(
            items = catList,
            itemContent = {
                CatCard(
                    cat = it,
                    action = { MainNavigator().goToDetailActivity(it.id!!, context = context) },
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
//    val catList = Datasource().loadAffirmations()
//    SaveTheCatTheme {
//        CatGrid(catList = catList)
//    }
}