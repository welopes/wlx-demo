package br.com.wlx.demo.login.domain.model

data class User(
    val id: String? = null,
    val userName: String? = null,
    val token: String? = null,
    val expiresIn: Long? = null
)