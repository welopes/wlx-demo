package br.com.wlx.login.data.remote.dto

data class LoginResponseDto(
    val token: String? = null,
    val userId: String? = null,
    val name: String,
    val expiresIn: Long
)