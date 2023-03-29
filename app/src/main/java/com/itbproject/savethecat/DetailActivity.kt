package com.itbproject.savethecat

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
import com.itbproject.savethecat.ui.screens.DetailScreen
import com.itbproject.savethecat.ui.theme.SaveTheCatTheme
import com.itbproject.savethecat.ui.viewmodels.DetailViewmodel

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        var id = ""

        intent.extras?.let {
            id = it.getString("id")!!
        }

        setContent {
            SaveTheCatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    StartScreen(id = id)
                }
            }
        }
    }
}

@Composable
fun StartScreen(viewModel: DetailViewmodel = viewModel(), id: String){
    val detailState by viewModel.detailState.collectAsState()
    viewModel.loadBreed(id)
    DetailScreen(breedModel = detailState!!)
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {

}