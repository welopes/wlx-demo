package br.com.wlx.demo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import br.com.wlx.demo.home.HomeLauncher
import br.com.wlx.demo.login.LoginLauncher
import br.com.wlx.demo.onboarding.OnboardingLauncher
import br.com.wlx.demo.presentation.ui.MainActivity

sealed class Journey(val route: String) {
    object Onboarding : Journey("onboarding_journey")
    object Login : Journey("login_journey")
    object Home : Journey("home_journey")
}

sealed class Screen(val route: String) {
//    object Terms : Screen("terms")
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
            route = Journey.Login.route,
            goToHome = {
                navController.navigate(Journey.Home.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
        )

        HomeLauncher(
            navGraphBuilder = this,
            navController = navController,
            route = Journey.Home.route,
            onFinish = {
                activity.finishAffinity()
            }
        )

    }
}