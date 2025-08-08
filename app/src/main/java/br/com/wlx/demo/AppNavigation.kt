package br.com.wlx.demo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.wlx.demo.presentation.ui.AboutScreen
import br.com.wlx.demo.presentation.ui.MainActivity
import br.com.wlx.login.LoginLauncher
import br.com.wlx.onboarding.OnboardingLauncher

sealed class Journey(val route: String) {
    object Onboarding : Journey("onboarding_journey")
    object Login : Journey("login_journey")
}

sealed class Screen(val route: String) {
    object About : Screen("about")
}

@Composable
fun AppNavigation(navController: NavHostController, activity: MainActivity, startJourney: String) {

    NavHost(navController = navController, startDestination = startJourney) {
        OnboardingLauncher(
            navGraphBuilder = this,
            navController = navController,
            route = Journey.Onboarding.route,
            onFinish = {
                navController.navigate(Journey.Login.route)
            }
        )

        LoginLauncher(
            navGraphBuilder = this,
            navController = navController,
            route = Journey.Login.route
        )

        composable(Screen.About.route) {
            AboutScreen()
        }
    }
}