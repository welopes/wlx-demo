package br.com.wlx.demo.data.local.impl

import br.com.wlx.demo.data.local.UserPreferencesLocalDataSource
import br.com.wlx.storage.api.Storage

class UserPreferencesLocalDataSourceImpl(private val storage: Storage) :
    UserPreferencesLocalDataSource {

    private val ONBOARDING_COMPLETED_KEY = "onboarding_completed"

    override suspend fun isOnboardingCompleted(): Boolean {
        return storage.getBoolean(ONBOARDING_COMPLETED_KEY) ?: false
    }
}