package br.com.wlx.demo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wlx.demo.Journey
import br.com.wlx.demo.domain.usecase.CheckOnboardingCompletedUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    private val checkOnboardingCompletedUseCase: CheckOnboardingCompletedUseCase
) : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _startJourney = MutableStateFlow("")
    val startJourney: StateFlow<String> = _startJourney

    init {
        viewModelScope.launch {
            _isLoading.value = true
            val completed = checkOnboardingCompletedUseCase()
            _startJourney.value = if (completed) Journey.Login.route else Journey.Onboarding.route
            _isLoading.value = false
        }
    }

}