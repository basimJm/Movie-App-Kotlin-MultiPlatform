package com.blackhand.moviekmp.data.repo

import com.blackhand.moviekmp.common.utils.toMovieResultModel
import com.blackhand.moviekmp.data.remote.MovieDataSource
import com.blackhand.moviekmp.domain.model.MovieResultModel
import com.blackhand.moviekmp.domain.repo.MovieRepository

internal class MovieRepositoryImpl(private val movieDataSource: MovieDataSource) : MovieRepository {
    override suspend fun getMovies(page: Int): List<MovieResultModel>? {
        return movieDataSource.getMoviesList(page)?.results?.map { it.toMovieResultModel() }
    }

    override suspend fun getMovieDetails(id: Int): MovieResultModel? {
        return movieDataSource.getMovieDetails(id)?.toMovieResultModel()
    }
}