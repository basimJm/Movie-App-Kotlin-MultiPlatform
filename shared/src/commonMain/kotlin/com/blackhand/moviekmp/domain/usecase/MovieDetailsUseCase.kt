package com.blackhand.moviekmp.domain.usecase

import com.blackhand.moviekmp.domain.model.MovieResultModel
import com.blackhand.moviekmp.domain.repo.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

 class MovieDetailsUseCase : KoinComponent {
    private val repository: MovieRepository by inject()
    suspend operator fun invoke(id: Int): MovieResultModel? {
        return repository.getMovieDetails(id)
    }
}