package br.com.wlx.login.presentation.viewmodel

data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false,
    val isLoginButtonEnabled: Boolean = false
)