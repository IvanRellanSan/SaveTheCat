package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbproject.savethecat.data.Datasource
import com.itbproject.savethecat.model.Cat
import com.itbproject.savethecat.ui.theme.SaveTheCatTheme

@Composable
fun CatCard(cat: Cat, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(0.dp),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.background)
        ) {
            Image(
                painter = painterResource(
                    id = cat.imageResourceId
                ),
                contentDescription = "Cat",
            )

            Text(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally),
                text = stringResource(cat.nameResourceId),
                style = MaterialTheme.typography.h3
            )

            Divider(
                thickness = 4.dp
            )

            if (expanded){
                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(start = 16.dp, end = 16.dp),
                    text = stringResource(cat.descriptionResourceId),
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Justify,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )

                CatTextButton(
                    onClick = { /*TODO*/ },
                    text = "See meowre...",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }

            ExpandButton(
                onClick = { expanded = !expanded },
                expanded = expanded,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
fun CatCardPreview() {
    val cat = Datasource().loadAffirmations()[0]

    SaveTheCatTheme {
        CatCard(cat)
    }
}