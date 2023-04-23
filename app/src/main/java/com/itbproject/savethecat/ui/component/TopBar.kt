package com.itbproject.savethecat.ui.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.itbproject.savethecat.R
import com.itbproject.savethecat.ui.viewmodels.GridViewModel

@Composable
fun TopBar(viewModel: GridViewModel) {
    var menuExpanded by remember{
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
                        viewModel.sortByName()
                        menuExpanded = false
                    }
                )
                DropdownMenuItem(
                    content = {
                        Text(
                            text = "By country"
                        ) },
                    onClick = {
                        viewModel.sortByCountry()
                        menuExpanded = false
                    }
                )
            }

        }
    )
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar(GridViewModel())
}