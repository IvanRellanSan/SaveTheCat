package com.itbproject.savethecat.ui.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.filled.ExpandMore


@Composable
fun ExpandButton(onClick: () -> Unit, expanded: Boolean, modifier: Modifier = Modifier){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = "Expand Icon")
    }
}

@Preview
@Composable
fun ButtonPreview() {
    ExpandButton(onClick = { /*TODO*/ }, expanded = false, modifier = Modifier)
}
