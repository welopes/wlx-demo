package br.com.wlx.demo

import android.app.Application
import br.com.wlx.demo.di.appModule
import br.com.wlx.login.di.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class WLXDemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@WLXDemoApplication)

            modules(appModule + loginModule)
        }
    }
}