package br.com.wlx.demo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking

class SplashViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        _isLoading.value = true
        checkAuthentication()
        _isLoading.value = false
    }

    private fun checkAuthentication() {
        runBlocking {
            delay(1000L)
        }
    }
}