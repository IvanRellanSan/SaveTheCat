package com.itbproject.savethecat.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.itbproject.savethecat.data.models.Image

@OptIn(ExperimentalPagerApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun ImageCarousel(images: List<Image>) {
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = images.size,
        state = pagerState
    ) {
        page ->
            GlideImage(
                model = images[page],
                contentDescription = "Cat"
            )
    }
}

@Preview
@Composable
fun ImageCarouselPreview() {

}