package br.com.wlx.demo.login.data.remote

import br.com.wlx.demo.login.data.remote.dto.LoginResponseDto
import br.com.wlx.foundation.data.remote.BaseRemoteDataSource

interface LoginRemoteDataSource: BaseRemoteDataSource {
    suspend fun login(username: String, password: String): LoginResponseDto
}