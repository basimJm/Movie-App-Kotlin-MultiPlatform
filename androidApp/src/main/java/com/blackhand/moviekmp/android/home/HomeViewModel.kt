package com.blackhand.moviekmp.android.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blackhand.moviekmp.domain.model.MovieResultModel
import com.blackhand.moviekmp.domain.usecase.MoviesListUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    val getMoviesUseCase: MoviesListUseCase
) : ViewModel() {
    var uiState by mutableStateOf(HomeScreenState())
    private var currentPage = 2

    init {
        loadMovies(forceReload = false)
    }


    fun loadMovies(forceReload: Boolean = false) {
        if (uiState.loading) return
        if (forceReload) currentPage = 2
        if (currentPage == 2) uiState = uiState.copy(refreshing = true)

        viewModelScope.launch {
            uiState = uiState.copy(
                loading = true
            )

            try {
                val resultMovies = getMoviesUseCase(page = currentPage)
                val movies = if (currentPage == 2) {
                    resultMovies ?: listOf()
                } else {
                    (uiState.movies) + (resultMovies ?: listOf())
                }
                currentPage += 1
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = resultMovies?.isEmpty() ?: false,
                    movies = movies
                )

            } catch (error: Throwable) {
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = true,
                    errorMessage = "Could not load movies: ${error.localizedMessage}"
                )
            }
        }
    }
}


data class HomeScreenState(
    var loading: Boolean = false,
    var refreshing: Boolean = false,
    var movies: List<MovieResultModel> = listOf(),
    var errorMessage: String? = null,
    var loadFinished: Boolean = false
)



















