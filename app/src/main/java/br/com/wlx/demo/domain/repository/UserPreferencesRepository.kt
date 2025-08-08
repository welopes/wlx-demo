package br.com.wlx.demo.domain.repository

import br.com.wlx.foundation.domain.repository.BaseRepository

interface UserPreferencesRepository : BaseRepository {
    suspend fun isOnboardingCompleted(): Boolean
}