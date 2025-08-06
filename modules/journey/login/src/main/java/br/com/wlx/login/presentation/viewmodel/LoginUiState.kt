package br.com.wlx.login.presentation.viewmodel

data class LoginUiState(
    val username: String = "user123",
    val password: String = "pass123",
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)