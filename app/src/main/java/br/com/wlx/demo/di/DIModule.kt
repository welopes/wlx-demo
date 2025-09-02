package br.com.wlx.demo.di

import br.com.wlx.analytics.api.AnalyticsTracker
import br.com.wlx.analytics.api.CrashReporter
import br.com.wlx.analytics.impl.FirebaseAnalyticsTracker
import br.com.wlx.analytics.impl.FirebaseCrashReporter
import br.com.wlx.communication.api.ApiClient
import br.com.wlx.communication.impl.OkHttpApiClient
import br.com.wlx.demo.BuildConfig
import br.com.wlx.demo.data.local.UserPreferencesLocalDataSource
import br.com.wlx.demo.data.local.impl.UserPreferencesLocalDataSourceImpl
import br.com.wlx.demo.data.repository.impl.UserPreferencesRepositoryImpl
import br.com.wlx.demo.domain.repository.UserPreferencesRepository
import br.com.wlx.demo.domain.usecase.CheckOnboardingCompletedUseCase
import br.com.wlx.demo.presentation.viewmodel.SplashViewModel
import br.com.wlx.logger.api.Logger
import br.com.wlx.logger.impl.TimberLogger
import br.com.wlx.storage.api.Storage
import br.com.wlx.storage.impl.encrypteddatastore.EncryptedDataStoreStorage
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    single<CrashReporter> { FirebaseCrashReporter(androidContext(), BuildConfig.APPLICATION_ID) }

    single<AnalyticsTracker> { FirebaseAnalyticsTracker() }

    single<Logger> { TimberLogger() }

    single<Storage> { EncryptedDataStoreStorage(androidContext()) }

    single<String>(qualifier = named("BASE_URL")) {
        "https://wlxdemo.free.beeceptor.com"
    }

//    single<CertificatePinner?> {
//        CertificatePinner.Builder()
//            .add("api.seuservidor.com", "sha256/AAAA...")
//            .build()
//    }

    single<ApiClient> {
        OkHttpApiClient(
            baseUrl = get(qualifier = named("BASE_URL")),
            logger = get()
        )
    }

    single<UserPreferencesLocalDataSource> { UserPreferencesLocalDataSourceImpl(storage = get()) }
    single<UserPreferencesRepository> { UserPreferencesRepositoryImpl(local = get()) }
    factory { CheckOnboardingCompletedUseCase(repository = get()) }
    viewModel { SplashViewModel(checkOnboardingCompletedUseCase = get()) }
}