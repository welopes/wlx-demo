package br.com.wlx.demo.login.presentation.viewmodel

data class LoginUiState(
    val username: String = "sdsds",
    val password: String = "sdsdsds",
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false,
    val isLoginButtonEnabled: Boolean = false
)