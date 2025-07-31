package br.com.wlx.login.domain.repository

import br.com.wlx.foundation.domain.repository.BaseRepository

interface LoginRepository : BaseRepository {
    fun login(username: String, password: String)
}