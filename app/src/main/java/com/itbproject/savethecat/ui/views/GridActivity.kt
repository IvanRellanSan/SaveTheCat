package com.itbproject.savethecat.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itbproject.savethecat.ui.screens.GridScreen
import com.itbproject.savethecat.ui.theme.SaveTheCatTheme
import com.itbproject.savethecat.ui.viewmodels.GridViewModel

class GridActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaveTheCatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    StartScreen()
                }
            }
        }
    }
}

@Composable
fun StartScreen(
    viewModel: GridViewModel = viewModel()
) {
    val cats by viewModel.gridState.collectAsState()
    //viewModel.getBreeds()
    GridScreen(
        catList = cats,
        viewModel = viewModel
    )
//    CatGrid(
//        catList,
//        modifier = Modifier
//            .fillMaxSize()
//    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SaveTheCatTheme {
        StartScreen()
    }
}