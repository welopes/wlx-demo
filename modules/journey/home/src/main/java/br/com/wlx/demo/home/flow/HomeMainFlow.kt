package br.com.wlx.demo.home.flow

import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import br.com.wlx.demo.home.HomeLauncher.Screen
import br.com.wlx.demo.home.R
import br.com.wlx.demo.home.presentation.ui.AboutScreen
import br.com.wlx.demo.home.presentation.ui.DrawerWrapper
import br.com.wlx.demo.home.presentation.ui.HomeScreen

class HomeMainFlow(val navGraphBuilder: NavGraphBuilder) {

    fun flow(navController: NavHostController, route: String, onFinish: () -> Unit) {
        navGraphBuilder.navigation(
            startDestination = Screen.Home.route, route = route
        ) {
            composable(Screen.Home.route) {
                DrawerWrapper(
                    { HomeScreen() },
                    title = stringResource(R.string.home),
                    goToHome = { },
                    goToAbout = { navController.navigate(Screen.About.route) },
                    onFinish = onFinish
                )
            }

            composable(Screen.About.route) {
                val goToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.About.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }

                DrawerWrapper(
                    {
                        AboutScreen(goToHome = goToHome)
                    },
                    title = stringResource(R.string.about),
                    goToHome = goToHome,
                    goToAbout = { },
                    onFinish = onFinish
                )
            }
        }
    }
}
