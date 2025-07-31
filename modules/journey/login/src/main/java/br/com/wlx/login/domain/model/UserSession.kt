package br.com.wlx.login.domain.model

data class UserSession(
    val userId: String,
    val userName: String,
    val accessToken: String
)