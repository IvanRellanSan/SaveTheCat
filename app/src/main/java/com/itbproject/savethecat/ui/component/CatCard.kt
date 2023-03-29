package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.itbproject.savethecat.data.models.BreedModel
import com.itbproject.savethecat.ui.theme.SaveTheCatTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CatCard(cat: BreedModel, modifier: Modifier = Modifier) {
//    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .clickable {  },
        shape = RoundedCornerShape(0.dp),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.background)
        ) {
            GlideImage(
                model = cat.image?.url,
                contentDescription = "Cat",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
            )

            Text(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally),
                text = cat.name!!,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h3
            )

            Divider(
                thickness = 4.dp
            )

            Text(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(start = 16.dp, end = 16.dp),
                text = cat.description!!,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Justify,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )

//            ExpandButton(
//                onClick = { expanded = !expanded },
//                expanded = expanded,
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//            )
        }
    }
}

@Preview
@Composable
fun CatCardPreview() {
    val cat = BreedModel()

    SaveTheCatTheme {
        CatCard(cat)
    }
}