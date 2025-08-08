package br.com.wlx.demo.login.domain.repository

import br.com.wlx.demo.login.domain.model.User
import br.com.wlx.foundation.domain.repository.BaseRepository

interface LoginRepository : BaseRepository {
    suspend fun login(username: String, password: String): User
}