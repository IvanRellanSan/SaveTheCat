package com.itbproject.savethecat.ui.component

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.itbproject.savethecat.data.Datasource
import com.itbproject.savethecat.ui.theme.SaveTheCatTheme

@Composable
fun GridScreen(modifier: Modifier = Modifier) {
    val catList = Datasource().loadAffirmations()
    val scaffoldState= rememberScaffoldState()
    Scaffold(
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
    SaveTheCatTheme() {
        GridScreen()
    }
}
