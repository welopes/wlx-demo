package br.com.wlx.login.di

import br.com.wlx.login.data.remote.LoginRemoteDataSource
import br.com.wlx.login.data.remote.impl.LoginRemoteDataSourceImpl
import br.com.wlx.login.data.repository.impl.LoginRepositoryImpl
import br.com.wlx.login.domain.repository.LoginRepository
import br.com.wlx.login.domain.usecase.LoginUseCase
import br.com.wlx.login.presentation.viewmodel.LoginViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {

    single<LoginRemoteDataSource> { LoginRemoteDataSourceImpl(service = get()) }
    single<LoginRepository> { LoginRepositoryImpl(remote = get()) }
    single { LoginUseCase(repository = get()) }
    viewModel { LoginViewModel(logger = get(), useCase = get()) }
}