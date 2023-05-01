package com.itbproject.savethecat.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.itbproject.savethecat.R
import com.itbproject.savethecat.ui.models.BreedUiModel
import com.itbproject.savethecat.ui.theme.SaveTheCatTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CatCard(cat: BreedUiModel, modifier: Modifier = Modifier, action: () -> Unit) {
//    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .clickable(
                onClick = action
            ),
        shape = RoundedCornerShape(0.dp),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.background)
        ) {
            if (cat.breedImageUrl != null){
                GlideImage(
                    model = cat.breedImageUrl,
                    contentDescription = "Cat",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                )
            }
            else{
                Image(
                    painter = painterResource(id = R.drawable.default_cat),
                    contentDescription = stringResource(id = R.string.SadCat),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                )
            }

            Text(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally),
                text = cat.breedName,
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
                text = cat.breedDescription,
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
    val cat = BreedUiModel(
        id = "avecrem",
        breedName = "El gato del preview",
        breedDescription = "Es un gato usado para preview solo. Está triste",
        breedImageUrl = null,
        origin = "BCN",
        countryCode = "ES"
    )

    SaveTheCatTheme {
        CatCard(
            cat,
            action = { },
            modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ))
    }
}