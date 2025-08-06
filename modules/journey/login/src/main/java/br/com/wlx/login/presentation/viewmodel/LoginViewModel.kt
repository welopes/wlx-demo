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

    fun onUsernameChange(newUsername: String) {
        uiState = uiState.copy(
            username = newUsername,
            isLoginButtonEnabled = isValidUsername(newUsername) && isValidPassword(uiState.password)
        )
    }

    fun onPasswordChange(newPassword: String) {
        uiState = uiState.copy(
            password = newPassword,
            isLoginButtonEnabled = isValidUsername(uiState.username) && isValidPassword(newPassword)
        )
    }

    private fun isValidUsername(username: String): Boolean {
        return username.length >= 3
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 5
    }

    fun login() {
        if (!uiState.isLoginButtonEnabled) return

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