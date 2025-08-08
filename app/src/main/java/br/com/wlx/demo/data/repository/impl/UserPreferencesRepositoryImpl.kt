package br.com.wlx.demo.data.repository.impl

import br.com.wlx.demo.data.local.UserPreferencesLocalDataSource
import br.com.wlx.demo.domain.repository.UserPreferencesRepository
import br.com.wlx.foundation.data.remote.BaseRemoteDataSource

class UserPreferencesRepositoryImpl(
    override val local: UserPreferencesLocalDataSource,
    override val remote: BaseRemoteDataSource? = null
) : UserPreferencesRepository {

    override suspend fun isOnboardingCompleted(): Boolean {
        return local.isOnboardingCompleted()
    }
}
