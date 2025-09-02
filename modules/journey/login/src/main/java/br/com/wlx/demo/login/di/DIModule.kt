package br.com.wlx.demo.login.di

import br.com.wlx.demo.login.data.remote.LoginRemoteDataSource
import br.com.wlx.demo.login.data.remote.impl.LoginRemoteDataSourceImpl
import br.com.wlx.demo.login.data.repository.impl.LoginRepositoryImpl
import br.com.wlx.demo.login.domain.repository.LoginRepository
import br.com.wlx.demo.login.domain.usecase.LoginUseCase
import br.com.wlx.demo.login.presentation.viewmodel.LoginViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {

    single<LoginRemoteDataSource> { LoginRemoteDataSourceImpl(apiClient = get()) }
    single<LoginRepository> { LoginRepositoryImpl(remote = get()) }
    factory { LoginUseCase(repository = get()) }
    viewModel { LoginViewModel(logger = get(), useCase = get()) }
}