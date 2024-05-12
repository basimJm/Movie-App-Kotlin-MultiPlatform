package com.blackhand.moviekmp.android.detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blackhand.moviekmp.domain.model.MovieResultModel
import com.blackhand.moviekmp.domain.usecase.MovieDetailsUseCase
import kotlinx.coroutines.launch

class DetailViewModel(
    val getMovieUseCase: MovieDetailsUseCase,
    val movieId: Int
) : ViewModel() {
    var uiState by mutableStateOf(DetailScreenState())

    init {
        loadMovie(movieId)
    }

    private fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)

            uiState = try {
                val movie = getMovieUseCase(id = movieId)
                Log.d("asdasdasda","details is ${movie}")
                uiState.copy(loading = false, movie = movie)
            } catch (error: Throwable) {
                Log.d("asdasdasda","error is ${error}")
                uiState.copy(
                    loading = false,
                    errorMessage = "Could not load the movie"
                )
            }
        }
    }
}

data class DetailScreenState(
    var loading: Boolean = false,
    var movie: MovieResultModel? = null,
    var errorMessage: String? = null
)










