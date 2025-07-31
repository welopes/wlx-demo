package br.com.wlx.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import br.com.wlx.login.flow.LoginMainFlow

class LoginLauncher(
    navGraphBuilder: NavGraphBuilder,
    private val navController: NavHostController,
    route: String
) {
    sealed class Screen(val route: String) {
        object Login : Screen("login")
    }

    init {
        navGraphBuilder.apply {
            LoginMainFlow(navGraphBuilder).flow(navController, route)
        }
    }
}