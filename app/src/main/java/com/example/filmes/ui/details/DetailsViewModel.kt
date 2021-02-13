package com.example.filmes.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmes.data.model.Movie
import com.example.filmes.repository.Repository
import kotlinx.coroutines.launch

class DetailsViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    fun addFavotite(movie: Movie) {
        viewModelScope.launch {
            repository.favoriteRepository.addToFavorite(
               movie
            )
        }
    }

    suspend fun checkMovie(movie: Movie) = repository.favoriteRepository.checkMovie(movie)

    fun remoteFromFavorite(movie: Movie) {
        viewModelScope.launch {
            repository.favoriteRepository.removeFromFavorite(movie)
        }
    }

}