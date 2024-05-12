package com.blackhand.moviekmp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MoviesRemoteModel(
    @SerialName("page")
    var page: Int? = null,
    @SerialName("results")
    var results: List<MovieResultRemoteModel>? = null,
    @SerialName("total_pages")
    var totalPages: Int? = null,
    @SerialName("total_results")
    var totalResults: Int? = null,
)