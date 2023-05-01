package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.itbproject.savethecat.R

@OptIn(ExperimentalPagerApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun ImageCarousel(images: List<String>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()

    HorizontalPager(
        modifier = modifier,
        count = if (images.isNotEmpty()) images.size else 10,
        state = pagerState
    ) {
        page ->
            if (images.isNotEmpty()){
                GlideImage(
                    model = images[page],
                    contentDescription = "Cat",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(400.dp)
                        .fillMaxWidth()
                )
            }
            else{
                Image(
                    painter = painterResource(
                        id = R.drawable.default_cat
                    ),
                    contentDescription = stringResource(id = R.string.SadCat),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(400.dp)
                        .fillMaxWidth()
                )
            }
    }
}

@Preview
@Composable
fun ImageCarouselPreview() {

}