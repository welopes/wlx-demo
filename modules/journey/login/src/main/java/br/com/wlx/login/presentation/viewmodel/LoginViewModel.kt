package br.com.wlx.login.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import br.com.wlx.foundation.presentation.viewmodel.BaseViewModel
import br.com.wlx.logger.api.Logger
import br.com.wlx.login.domain.usecase.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(
    override val useCase: LoginUseCase,
    val logger: Logger
) : BaseViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onUsernameChange(value: String) {
        uiState = uiState.copy(username = value)
    }

    fun onPasswordChange(value: String) {
        uiState = uiState.copy(password = value)
    }

    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            uiState = uiState.copy(isLoading = true, error = null, success = false)
            try {
                val isLogged = useCase.login(uiState.username, uiState.password)
                if (isLogged) {
                    uiState = uiState.copy(isLoading = false, success = true)
                     return@launch
                } else {
                    uiState = uiState.copy(isLoading = false, error = "Login failed")
                }

            } catch (e: Exception) {
                logger.error("Login failed", e)
                uiState = uiState.copy(isLoading = false, error = e.message)
            }
        }
    }
}