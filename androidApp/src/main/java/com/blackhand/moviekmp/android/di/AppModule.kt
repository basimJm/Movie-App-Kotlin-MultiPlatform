package com.blackhand.moviekmp.android.di

import com.blackhand.moviekmp.android.detail.DetailViewModel
import com.blackhand.moviekmp.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> DetailViewModel(getMovieUseCase = get(), movieId = params.get()) }
}