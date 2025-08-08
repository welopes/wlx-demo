package br.com.wlx.demo

import android.app.Application
import br.com.wlx.demo.di.appModule
import br.com.wlx.demo.home.di.homeModule
import br.com.wlx.demo.login.di.loginModule
import br.com.wlx.demo.onboarding.di.onboardingModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class WLXDemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
//        } else {
//            Timber.plant(SentryTree()) // CrashlyticsTree, etc.
        }

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@WLXDemoApplication)

            modules(appModule + onboardingModule + loginModule + homeModule)
        }
    }
}