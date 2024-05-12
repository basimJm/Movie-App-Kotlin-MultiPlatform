package com.blackhand.moviekmp.data.remote

import com.blackhand.moviekmp.data.model.MovieResultRemoteModel
import com.blackhand.moviekmp.data.model.MoviesRemoteModel
import com.blackhand.moviekmp.common.utils.Dispatcher
import kotlinx.coroutines.withContext

internal class MovieDataSource(
    private val movieService: MovieService,
    private val dispatcher: Dispatcher
) {
    suspend fun getMoviesList(page: Int): MoviesRemoteModel? {
        return withContext(dispatcher.io) {
            movieService.getMovies(page)
        }
    }

    suspend fun getMovieDetails(id: Int): MovieResultRemoteModel? {
        return withContext(dispatcher.io) {
            movieService.getVideoDetails(id)
        }
    }
}