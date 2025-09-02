package br.com.wlx.demo.login.data.remote.dto

data class LoginResponseDto(
    val token: String? = null,
    val userId: String? = null,
    val name: String = "",
    val expiresIn: Long = 0L
)