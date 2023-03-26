package com.itbproject.savethecat.ui.component

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.itbproject.savethecat.data.Datasource
import com.itbproject.savethecat.ui.theme.SaveTheCatTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itbproject.savethecat.model.BreedModel
import com.itbproject.savethecat.model.Cat
import com.itbproject.savethecat.ui.viewmodels.GridViewModel

@Composable
fun GridScreen(modifier: Modifier = Modifier, catList: List<BreedModel>) {
    val scaffoldState= rememberScaffoldState()
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            TopBar()
        }
    ) {
        CatGrid(catList = catList)
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
