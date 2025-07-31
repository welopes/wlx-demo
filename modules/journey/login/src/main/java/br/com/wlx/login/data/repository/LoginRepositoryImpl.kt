package br.com.wlx.login.data.repository

import br.com.wlx.logger.api.Logger
import br.com.wlx.login.data.local.LoginLocalDataSource
import br.com.wlx.login.data.remote.LoginRemoteDataSource
import br.com.wlx.login.domain.repository.LoginRepository

class LoginRepositoryImpl(
    override val logger: Logger,
    override val local: LoginLocalDataSource?,
    override val remote: LoginRemoteDataSource?
) : LoginRepository {
    override fun login(username: String, password: String) {
//        remote.login(username, password)
    }
}