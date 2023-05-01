package com.itbproject.savethecat.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbproject.savethecat.coroutines.AppDispatchers
import com.itbproject.savethecat.data.network.*
import com.itbproject.savethecat.ui.models.LoginUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class MainViewmodel(
    private val apiService: UsersApiService = UsersApi.retrofitService,
    private val appDispatchers: AppDispatchers = AppDispatchers()
) : ViewModel() {
    private val _loginState = MutableStateFlow<LoginState>(LoginState.START)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    var userName by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    fun checkCredentials() {
        viewModelScope.launch {
            _loginState.value = LoginState.LOADING(
                LoginUiModel(
                    user = userName,
                    pssw = password
                )
            )

            viewModelScope.launch {
                try{
                    val userList = withContext(appDispatchers.IO) { apiService.getUsers() }

                    userList.let {
                        for(i in userList.indices){
                            if (userList[i].username == ((loginState.value as LoginState.LOADING).loginState.user)){
                                if (FAKE_PASSWORDS[i] == (loginState.value as LoginState.LOADING).loginState.pssw){
                                    _loginState.value = LoginState.SUCCESS
                                }

                                break
                            }
                        }

                        if (_loginState.value != LoginState.SUCCESS){
                            _loginState.value = LoginState.FAILURE
                        }
                    }
                }
                catch (e: IOException){
                    _loginState.value = LoginState.ERROR(e.localizedMessage!!)
                }
            }
        }
    }

    fun updateUsername(name: String){
        userName = name
    }

    fun updatePassword(pass: String){
        password = pass
    }

    fun restart(){
        _loginState.value = LoginState.START
    }
}

sealed class LoginState {
    object START : LoginState()
    data class LOADING(val loginState: LoginUiModel): LoginState()
    object SUCCESS : LoginState()
    object FAILURE : LoginState()
    data class ERROR(val message: String) : LoginState()
}