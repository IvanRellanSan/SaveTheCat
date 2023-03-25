package com.itbproject.savethecat.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.itbproject.savethecat.data.Datasource
import com.itbproject.savethecat.model.Cat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GridViewModel : ViewModel() {
    private val datasource = Datasource()

    private val _gridState = MutableStateFlow<List<Cat>>(mutableListOf())
    val gridState: StateFlow<List<Cat>> = _gridState.asStateFlow()

    fun loadState(){
        _gridState.value = datasource.loadAffirmations()
    }
}