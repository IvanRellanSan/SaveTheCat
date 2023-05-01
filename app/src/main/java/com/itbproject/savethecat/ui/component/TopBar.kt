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
    sortBy: (SortBy) -> Unit,
    filterBy: (String) -> Unit,
    countryList: List<String> = mutableListOf("")
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
                        sortBy(SortBy.Alphabetically)
                        menuExpanded = false
                    }
                )
                DropdownMenuItem(
                    content = {
                        Text(
                            text = "By country"
                        ) },
                    onClick = {
                        sortBy(SortBy.Country)
                        menuExpanded = false
                    }
                )
            }
            IconButton(
                onClick = {
                    filterMenuExpanded = !filterMenuExpanded
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.FilterAlt,
                    contentDescription = "Filter"
                )
            }
            DropdownMenu(
                expanded = filterMenuExpanded,
                onDismissRequest = {
                    filterMenuExpanded = false
                }
            ) {
                for(item in countryList){
                    DropdownMenuItem(
                        content = {
                            Text(
                                text = item
                            ) },
                        onClick = {
                            filterBy(item)
                            filterMenuExpanded = false
                        }
                    )
                }
            }
        }
    )
}

sealed class SortBy{
    object Alphabetically: SortBy()
    object Country: SortBy()
}

sealed class FilterBy{
    object Country: FilterBy()
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar({ }, { })
}