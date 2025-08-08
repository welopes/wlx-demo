package br.com.wlx.demo.data.local

import br.com.wlx.foundation.data.local.BaseLocalDataSource

interface UserPreferencesLocalDataSource: BaseLocalDataSource {
    suspend fun isOnboardingCompleted(): Boolean
}