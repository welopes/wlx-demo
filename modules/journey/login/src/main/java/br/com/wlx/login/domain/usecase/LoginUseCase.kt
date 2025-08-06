package br.com.wlx.login.domain.usecase

import br.com.wlx.foundation.domain.usecase.BaseUseCase
import br.com.wlx.login.domain.repository.LoginRepository


class LoginUseCase(
    override val repository: LoginRepository
) : BaseUseCase {

    suspend fun login(username: String, password: String): Boolean {
        val user = repository.login(username, password)
        return user.token?.isNotEmpty() ?: false
    }

}
