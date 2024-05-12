package com.blackhand.moviekmp.data.di

import com.blackhand.moviekmp.common.utils.provideDispatcher
import com.blackhand.moviekmp.data.remote.MovieDataSource
import com.blackhand.moviekmp.data.remote.MovieService
import com.blackhand.moviekmp.data.repo.MovieRepositoryImpl
import com.blackhand.moviekmp.domain.repo.MovieRepository
import com.blackhand.moviekmp.domain.usecase.MovieDetailsUseCase
import com.blackhand.moviekmp.domain.usecase.MoviesListUseCase
import org.koin.dsl.module

private val dataModule = module {
    factory { MovieService() }
    factory { MovieDataSource(get(), get()) }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { MovieDetailsUseCase() }
    factory { MoviesListUseCase() }
}

private val commonModule = module {
    factory { provideDispatcher() }
}

private val sharedModules = listOf(dataModule, domainModule, commonModule)

fun getSharedModule() = sharedModules