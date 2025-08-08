package br.com.wlx.demo.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import br.com.wlx.demo.onboarding.flow.OnboardingMainFlow

class OnboardingLauncher(
    navGraphBuilder: NavGraphBuilder,
    private val navController: NavHostController,
    route: String,
    onFinish: () -> Unit
) {
    sealed class Screen(val route: String) {
        object Onboarding : Screen("onboarding")
    }

    init {
        navGraphBuilder.apply {
            OnboardingMainFlow(navGraphBuilder).flow(navController, route, onFinish = onFinish)
        }
    }
}