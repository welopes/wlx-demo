package br.com.wlx.onboarding.flow

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import br.com.wlx.onboarding.OnboardingLauncher.Screen
import br.com.wlx.onboarding.presentation.ui.OnboardingScreen

class OnboardingMainFlow(val navGraphBuilder: NavGraphBuilder) {

    fun flow(navController: NavHostController, route: String, onFinish: () -> Unit) {
        navGraphBuilder.navigation(
            startDestination = Screen.Onboarding.route, route = route
        ) {

            composable(Screen.Onboarding.route) {
                OnboardingScreen(onFinish = onFinish)
            }
        }
    }
}
