package br.com.wlx.login.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wlx.logger.api.Logger
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class LoginViewModel(
    val logger: Logger,
//     val usecase: LoginUseCase
) : ViewModel() {
    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(value: String) {
        uiState = uiState.copy(email = value)
    }

    fun onPasswordChange(value: String) {
        uiState = uiState.copy(password = value)
    }

    fun login() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, errorMessage = null)
            try {
                delay(1000L)
                // usecase.login(uiState.email, uiState.password)
            } catch (e: Exception) {
                logger.error(e)
                uiState = uiState.copy(errorMessage = e.message ?: "Erro inesperado")
            } finally {
                uiState = uiState.copy(isLoading = false)
            }
        }
    }
}