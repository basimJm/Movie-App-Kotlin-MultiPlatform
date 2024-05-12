package com.blackhand.moviekmp.data.remote

import com.blackhand.moviekmp.data.model.MovieResultRemoteModel
import com.blackhand.moviekmp.data.model.MoviesRemoteModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.parseQueryString

internal class MovieService : KtorClient() {

    // by implement abstract Ktor Client we can access to http client and pass end points and params
    suspend fun getMovies(page: Int): MoviesRemoteModel? = client.get {
        pathUrl("/3/movie/popular")
        parameter("page", page)
    }.body()

    suspend fun getVideoDetails(movieId: Int): MovieResultRemoteModel? = client.get {
        pathUrl("3/movie/${movieId}")
    }.body()
}