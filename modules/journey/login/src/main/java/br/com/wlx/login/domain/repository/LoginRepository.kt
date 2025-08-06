package br.com.wlx.login.domain.repository

import br.com.wlx.foundation.domain.repository.BaseRepository
import br.com.wlx.login.domain.model.User

interface LoginRepository : BaseRepository {
    suspend fun login(username: String, password: String): User
}