package com.blackhand.moviekmp.common.utils

import com.blackhand.moviekmp.data.model.MovieResultRemoteModel
import com.blackhand.moviekmp.domain.model.MovieResultModel

internal fun MovieResultRemoteModel.toMovieResultModel(): MovieResultModel {
    return MovieResultModel(
        adult = adult,
        backdropPath = backdropPath,
        genreIds = genreIds,
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = getImagePath(posterPath),
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount,
    )
}

fun getImagePath(path: String?) = "https://image.tmdb.org/t/p/w500${path}"