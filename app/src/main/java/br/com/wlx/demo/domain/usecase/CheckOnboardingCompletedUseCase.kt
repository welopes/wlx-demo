package br.com.wlx.demo.domain.usecase

import br.com.wlx.demo.domain.repository.UserPreferencesRepository
import br.com.wlx.foundation.domain.usecase.BaseUseCase

class CheckOnboardingCompletedUseCase(
    override val repository: UserPreferencesRepository
) : BaseUseCase {
    suspend operator fun invoke(): Boolean {
        return repository.isOnboardingCompleted()
    }
}
