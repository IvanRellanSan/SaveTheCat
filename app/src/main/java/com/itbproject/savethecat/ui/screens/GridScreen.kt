package com.itbproject.savethecat.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.itbproject.savethecat.ui.component.CatGrid
import com.itbproject.savethecat.ui.component.TopBar
import com.itbproject.savethecat.ui.viewmodels.GridViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itbproject.savethecat.ui.component.SortBy
import com.itbproject.savethecat.ui.viewmodels.GridState

@Composable
fun GridScreen(
    modifier: Modifier = Modifier,
    catList: GridState,
    viewModel: GridViewModel = viewModel()
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                {
                    when(it) {
                        SortBy.Alphabetically -> { viewModel.sortByName() }
                        SortBy.Country -> { viewModel.sortByCountry() }
                    }
            },{
                    viewModel.filterByCountry(it)
              },
            countryList = viewModel.countryList)
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
