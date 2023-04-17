package com.itbproject.savethecat.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.itbproject.savethecat.ui.models.LoginUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewmodel : ViewModel() {
    private val _loginState = MutableStateFlow<LoginUiModel?>(null)
    val gridState: StateFlow<LoginUiModel?> = _loginState.asStateFlow()

    var userName by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    fun checkCredentials(){

    }

    fun updateUsername(name: String){
        userName = name
    }

    fun updatePassword(pass: String){
        password = pass
    }

    fun setNewState(){
        val state = LoginUiModel(
            user = userName,
            pssw = password
        )

        _loginState.value = state
    }


}