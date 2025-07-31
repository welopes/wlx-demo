package br.com.wlx.login.domain.usecase

import br.com.wlx.foundation.domain.usecase.BaseUseCase
import br.com.wlx.logger.api.Logger
import br.com.wlx.login.domain.repository.LoginRepository


class LoginUseCase(
    override val logger: Logger, override val repository: LoginRepository?
) : BaseUseCase {

    fun login(username: String, password: String) {
//        repository.login(username, password)
    }

}
