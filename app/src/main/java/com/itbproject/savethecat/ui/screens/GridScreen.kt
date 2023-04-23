package com.itbproject.savethecat.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.itbproject.savethecat.data.models.BreedDto
import com.itbproject.savethecat.ui.component.CatGrid
import com.itbproject.savethecat.ui.component.TopBar
import com.itbproject.savethecat.ui.viewmodels.GridViewModel

@Composable
fun GridScreen(
    modifier: Modifier = Modifier,
    catList: List<BreedDto>,
    viewModel: GridViewModel
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(viewModel)
        }
    ) {
        CatGrid(
            catList = catList
        )
    }

}

@Preview
@Composable
fun GridScreenPreview() {
//    val cats = Datasource().loadAffirmations()
//    SaveTheCatTheme {
//        GridScreen(catList = cats)
//    }
}
