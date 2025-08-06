package br.com.wlx.login.domain.model

data class User(
    val id: String? = null,
    val userName: String,
    val token: String? = null,
    val expiresIn: Long
)