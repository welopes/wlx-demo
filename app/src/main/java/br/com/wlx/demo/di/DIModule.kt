package br.com.wlx.demo.di

import br.com.wlx.demo.presentation.viewmodel.SplashViewModel
import br.com.wlx.logger.api.Logger
import br.com.wlx.logger.impl.DefaultLogger
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import java.util.logging.Level
import java.util.logging.Logger as JULogger

val appModule = module {

    single<Logger> {
        DefaultLogger(JULogger.getLogger("WLog").apply {
            level = Level.ALL
        })
    }

//    single<AnalyticsTracker> { DefaultAnalyticsTracker() }

    viewModel { SplashViewModel() }

}