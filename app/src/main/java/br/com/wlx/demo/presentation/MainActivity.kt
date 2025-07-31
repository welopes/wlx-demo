package br.com.wlx.demo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import br.com.wlx.demo.AppNavigation
import br.com.wlx.demo.presentation.viewmodel.SplashViewModel
import br.com.wlx.demo.ui.theme.WLXDemoTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
            .apply {
                setKeepOnScreenCondition { return@setKeepOnScreenCondition viewModel.isLoading.value }
            }

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            WLXDemoTheme(darkTheme = false) {
                AppNavigation(rememberNavController(), this)
            }
        }
//        val logger: Logger by inject()
//        logger.info("MainActivity created")
    }
}