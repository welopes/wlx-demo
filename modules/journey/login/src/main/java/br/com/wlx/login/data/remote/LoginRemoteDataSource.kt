package br.com.wlx.login.data.remote

import br.com.wlx.foundation.data.remote.BaseRemoteDataSource
import br.com.wlx.login.data.remote.dto.LoginResponseDto

interface LoginRemoteDataSource: BaseRemoteDataSource {
    suspend fun login(username: String, password: String): LoginResponseDto
}