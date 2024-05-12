package com.blackhand.moviekmp.domain.usecase

import com.blackhand.moviekmp.domain.model.MovieResultModel
import com.blackhand.moviekmp.domain.repo.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MoviesListUseCase : KoinComponent {
    private val repository: MovieRepository by inject()
    suspend operator fun invoke(page: Int): List<MovieResultModel>? {
        return repository.getMovies(page)
    }
}