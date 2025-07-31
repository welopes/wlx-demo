package br.com.wlx.demo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.wlx.demo.presentation.AboutScreen
import br.com.wlx.demo.presentation.MainActivity
import br.com.wlx.login.LoginLauncher

sealed class Journey(val route: String) {
    object Login : Journey("login_journey")
}

sealed class Screen(val route: String) {
    object About : Screen("about")
}

@Composable
fun AppNavigation(navController: NavHostController, activity: MainActivity) {
    val route = Journey.Login.route

    NavHost(navController = navController, startDestination = route) {
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