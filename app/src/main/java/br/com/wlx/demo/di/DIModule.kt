package br.com.wlx.demo.di

import br.com.wlx.analytics.api.AnalyticsTracker
import br.com.wlx.analytics.api.CrashReporter
import br.com.wlx.analytics.impl.FirebaseAnalyticsTracker
import br.com.wlx.analytics.impl.FirebaseCrashReporter
import br.com.wlx.demo.BuildConfig
import br.com.wlx.demo.presentation.viewmodel.SplashViewModel
import br.com.wlx.logger.api.Logger
import br.com.wlx.logger.impl.TimberLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<CrashReporter> { FirebaseCrashReporter(androidContext(), BuildConfig.APPLICATION_ID) }

    single<AnalyticsTracker> { FirebaseAnalyticsTracker() }

    single<Logger> { TimberLogger() }

//    single<Storage> { EncryptedDataStoreStorage(get<Context>()) }

    viewModel { SplashViewModel() }

}