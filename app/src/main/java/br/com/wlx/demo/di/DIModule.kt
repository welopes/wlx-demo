package br.com.wlx.demo.di

import android.content.Context
import br.com.wlx.demo.presentation.viewmodel.SplashViewModel
import br.com.wlx.logger.api.Logger
import br.com.wlx.logger.impl.DefaultLogger
import br.com.wlx.storage.api.Storage
import br.com.wlx.storage.impl.encrypteddatastore.EncryptedDataStoreStorage
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import java.util.logging.Level
import java.util.logging.Logger as JULogger

val appModule = module {

    // Logging
    single<Logger> {
        DefaultLogger(JULogger.getLogger("WLog").apply {
            level = Level.ALL
        })
    }

    //----- Storage -----
//    // Data Store
//    single<Storage> { DataStoreStorage(get<Context>()) }
//    // EncryptedPrefs
    single<Storage> { EncryptedDataStoreStorage(get<Context>()) }
//    // Room
//    single {
//        Room.databaseBuilder(
//            get<Context>(),
//            StorageDatabase::class.java,
//            "wlx_db"
//        ).fallbackToDestructiveMigration().build()
//    }
//
//    single { get<StorageDatabase>().storageDao() }
//
//    single<Storage> { RoomStorage(get()) }
//    //----- Storage -----

    viewModel { SplashViewModel() }

}