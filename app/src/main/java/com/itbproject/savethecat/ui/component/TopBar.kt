package com.itbproject.savethecat.ui.component

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.itbproject.savethecat.R

@Composable
fun TopBar(
    soryBy: (SortBy)-> Unit
) {
    var menuExpanded by remember{
        mutableStateOf(false)
    }

    var filterMenuExpanded by remember{
        mutableStateOf(false)
    }

    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Abrir menú desplegable"
                )
            }
        },
        title = {
            Text(
                text = stringResource(id = R.string.app_name)
            ) },
        actions = {
            IconButton(
                onClick = {
                    menuExpanded = !menuExpanded
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Sort,
                    contentDescription = "Sort"
                )
            }
            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = {
                    menuExpanded = false
                }
            ) {
                DropdownMenuItem(
                    content = {
                        Text(
                            text = "Alphabetically"
                        ) },
                    onClick = {
                        soryBy(SortBy.Alphabetically)
                        menuExpanded = false
                    }
                )
                DropdownMenuItem(
                    content = {
                        Text(
                            text = "By country"
                        ) },
                    onClick = {
                        soryBy(SortBy.Country)
                        menuExpanded = false
                    }
                )
            }
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Filled.FilterAlt,
                    contentDescription = "Filter"
                )
            }
        }
    )
}

sealed class SortBy{
    object Alphabetically: SortBy()
    object Country: SortBy()
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar({ })
}