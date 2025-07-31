package br.com.wlx.login.data.mapper

import br.com.wlx.login.data.model.LoginResponseDto
import br.com.wlx.login.domain.model.UserSession

object LoginMapper {
    fun fromDto(dto: LoginResponseDto): UserSession {
        return UserSession(
            userId = dto.user_id,
            userName = dto.name,
            accessToken = dto.token
        )
    }
}