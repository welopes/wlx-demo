package br.com.wlx.demo.login.flow

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import br.com.wlx.demo.login.LoginLauncher.Screen
import br.com.wlx.demo.login.presentation.ui.LoginScreen

class LoginMainFlow(val navGraphBuilder: NavGraphBuilder) {

    fun flow(navController: NavHostController, route: String, goToHome: () -> Unit) {
        navGraphBuilder.navigation(
            startDestination = Screen.Login.route, route = route
        ) {
            composable(Screen.Login.route) {
                LoginScreen(onLoginSuccess = goToHome)
//                        LoginScreen(onLoginSuccess = {
//                    navController.navigate(Screen.Home.route) {
//                        popUpTo(Screen.Login.route) {
//                            inclusive = true
//                        }
//                        launchSingleTop = true
//                    }
//                }
            }
        }
    }
}
