package br.com.wlx.login.di

import br.com.wlx.login.presentation.viewmodel.LoginViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {

//    single<LoginRepository> { LoginRepositoryImpl(logger = get(), local = null, remote = null) }
//    single { LoginUseCase(logger = get(), repository = get()) }
    viewModel { LoginViewModel(logger = get()) }

}