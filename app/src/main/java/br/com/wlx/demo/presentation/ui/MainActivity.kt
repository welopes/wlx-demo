package br.com.wlx.demo.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import br.com.wlx.demo.AppNavigation
import br.com.wlx.demo.presentation.ui.theme.WLXDemoTheme
import br.com.wlx.demo.presentation.viewmodel.SplashViewModel
import br.com.wlx.logger.api.Logger
import br.com.wlx.storage.api.Storage
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
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
                val startJourney by viewModel.startJourney.collectAsState()
                if (startJourney.isEmpty()) {
                    Box(
                        Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    AppNavigation(rememberNavController(), this, startJourney)
                }
            }
        }

        val logger: Logger by inject()
        logger.debug("MainActivity created")

        val storage: Storage by inject()
        lifecycleScope.launch {
            val key = "welcome_message"
            storage.putString(key, "Welcome to WLX Demo!")
            logger.info(storage.getString(key) ?: "No welcome message found")
        }
    }
}