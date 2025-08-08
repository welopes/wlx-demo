package br.com.wlx.demo.login.domain.usecase

import br.com.wlx.demo.login.domain.repository.LoginRepository
import br.com.wlx.foundation.domain.usecase.BaseUseCase


class LoginUseCase(
    override val repository: LoginRepository
) : BaseUseCase {

    suspend fun login(username: String, password: String): Boolean {
        val user = repository.login(username, password)
        return user.token?.isNotEmpty() ?: false
    }

}
