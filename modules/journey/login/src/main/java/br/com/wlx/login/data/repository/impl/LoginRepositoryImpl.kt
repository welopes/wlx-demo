package br.com.wlx.login.data.repository.impl

import br.com.wlx.login.data.local.LoginLocalDataSource
import br.com.wlx.login.data.mapper.LoginMapper
import br.com.wlx.login.data.remote.LoginRemoteDataSource
import br.com.wlx.login.domain.model.User
import br.com.wlx.login.domain.repository.LoginRepository

class LoginRepositoryImpl(
    override val local: LoginLocalDataSource? = null,
    override val remote: LoginRemoteDataSource
) : LoginRepository {
    override suspend fun login(username: String, password: String): User {
        return LoginMapper.fromDto(remote.login(username, password))
    }
}