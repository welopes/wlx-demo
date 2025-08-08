package br.com.wlx.demo.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import br.com.wlx.demo.login.flow.LoginMainFlow

class LoginLauncher(
    navGraphBuilder: NavGraphBuilder,
    private val navController: NavHostController,
    route: String,
    goToHome: () -> Unit
) {
    sealed class Screen(val route: String) {
        object Login : Screen("login")
    }

    init {
        navGraphBuilder.apply {
            LoginMainFlow(navGraphBuilder).flow(navController, route, goToHome = goToHome)
        }
    }
}