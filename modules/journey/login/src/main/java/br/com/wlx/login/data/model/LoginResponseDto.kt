package br.com.wlx.login.data.model

data class LoginResponseDto(
    val user_id: String,
    val name: String,
    val token: String
)