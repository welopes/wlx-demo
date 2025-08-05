package br.com.wlx.login.flow

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import br.com.wlx.login.LoginLauncher.Screen
import br.com.wlx.login.presentation.ui.LoginScreen

class LoginMainFlow(val navGraphBuilder: NavGraphBuilder) {

    fun flow(navController: NavHostController, route: String) {
        navGraphBuilder.navigation(
            startDestination = Screen.Login.route,
            route = route
        ) {
            composable("login") {
                LoginScreen(onLoginSuccess = {})
            }
        }
    }
}
