package com.itbproject.savethecat.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbproject.savethecat.ui.models.LoginUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.RequestBody

class MainViewmodel : ViewModel() {
    private val _loginState = MutableStateFlow<LoginUiModel?>(null)
    val loginState: StateFlow<LoginUiModel?> = _loginState.asStateFlow()

    var userName by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    fun checkCredentials() {
        viewModelScope.launch {
            _loginState.value = LoginUiModel(
                user = userName,
                pssw = password
            )

//            MockedApiService.getMockAPI().login(RequestBody.create(
//                MediaType.parse("application/json"),
//                _loginState.value!!.toString()))
        }
    }

    fun updateUsername(name: String){
        userName = name
    }

    fun updatePassword(pass: String){
        password = pass
    }

    fun setNewState(){

    }


}