package br.com.wlx.demo.home.flow

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import br.com.wlx.demo.home.HomeLauncher.Screen
import br.com.wlx.demo.home.presentation.ui.AboutScreen
import br.com.wlx.demo.home.presentation.ui.HomeScreen

class HomeMainFlow(val navGraphBuilder: NavGraphBuilder) {

    fun flow(navController: NavHostController, route: String, onFinish: () -> Unit) {
        navGraphBuilder.navigation(
            startDestination = Screen.Home.route, route = route
        ) {
            composable(Screen.Home.route) {
                HomeScreen(onFinish = onFinish)
            }

            composable(Screen.About.route) {
                AboutScreen()
            }
        }
    }
}
