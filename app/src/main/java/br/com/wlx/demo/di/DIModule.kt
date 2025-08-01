package br.com.wlx.demo.di

import android.content.Context
import br.com.wlx.demo.presentation.viewmodel.SplashViewModel
import br.com.wlx.logger.api.Logger
import br.com.wlx.logger.impl.TimberLogger
import br.com.wlx.storage.api.Storage
import br.com.wlx.storage.impl.encrypteddatastore.EncryptedDataStoreStorage
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Logging
//    single<Logger> { DefaultLogger() }
    single<Logger> { TimberLogger() }

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