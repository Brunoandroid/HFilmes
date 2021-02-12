package com.example.filmes.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmes.data.db.FavoriteMovie
import com.example.filmes.data.db.FavoriteRepository
import com.example.filmes.data.model.Movie
import kotlinx.coroutines.launch

class DetailsViewModel @ViewModelInject constructor(
    private val repositoryDetails: FavoriteRepository
) : ViewModel() {

    fun addFavotite(movie: Movie) {
        viewModelScope.launch {
            repositoryDetails.addToFavorite(
                FavoriteMovie(
                    movie.id,
                    movie.originalTitle,
                    movie.overview,
                    movie.posterPath
                )
            )
        }
    }

    suspend fun checkMovie(id: Int) = repositoryDetails.checkMovie(id)

    fun remoteFromFavorite(id: Int) {
        viewModelScope.launch {
            repositoryDetails.removeFromFavorite(id)
        }
    }

}