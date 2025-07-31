package br.com.wlx.login.data.remote

import br.com.wlx.foundation.data.remote.BaseRemoteDataSource
import br.com.wlx.login.data.mapper.LoginMapper
import br.com.wlx.login.domain.model.UserSession

class LoginRemoteDataSource(private val api: LoginApi) : BaseRemoteDataSource {
    suspend fun login(email: String, password: String): UserSession {
        val response = api.login(email, password)
        return LoginMapper.fromDto(response)
    }
}
