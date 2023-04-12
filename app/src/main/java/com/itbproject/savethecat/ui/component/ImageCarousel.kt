package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun ImageCarousel(images: List<String>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()

    HorizontalPager(
        modifier = modifier,
        count = images.size,
        state = pagerState
    ) {
        page ->
            GlideImage(
                model = images[page],
                contentDescription = "Cat",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(400.dp)
                    .fillMaxWidth()
            )
    }
}

@Preview
@Composable
fun ImageCarouselPreview() {

}