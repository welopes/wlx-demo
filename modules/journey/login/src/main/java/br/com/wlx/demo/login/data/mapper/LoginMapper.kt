package br.com.wlx.demo.login.data.mapper

import br.com.wlx.demo.login.data.remote.dto.LoginResponseDto
import br.com.wlx.demo.login.domain.model.User

object LoginMapper {
    fun fromDto(dto: LoginResponseDto): User {
        return User(
            id = dto.userId,
            userName = dto.name,
            token = dto.token,
            expiresIn = dto.expiresIn
        )
    }
}