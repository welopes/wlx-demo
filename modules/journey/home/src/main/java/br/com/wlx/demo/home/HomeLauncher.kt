package br.com.wlx.demo.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import br.com.wlx.demo.home.flow.HomeMainFlow

class HomeLauncher(
    navGraphBuilder: NavGraphBuilder,
    private val navController: NavHostController,
    route: String,
    onFinish: () -> Unit
) {
    sealed class Screen(val route: String) {
        object Home : Screen("home")
        object About : Screen("about")
    }

    init {
        navGraphBuilder.apply {
            HomeMainFlow(navGraphBuilder).flow(navController, route, onFinish = onFinish)
        }
    }
}