package com.blackhand.moviekmp.domain.repo

import com.blackhand.moviekmp.domain.model.MovieResultModel

 interface MovieRepository {
    suspend fun getMovies(page: Int): List<MovieResultModel>?
    suspend fun getMovieDetails(id: Int): MovieResultModel?
}