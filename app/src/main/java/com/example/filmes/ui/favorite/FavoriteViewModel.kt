package com.example.filmes.ui.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.filmes.repository.Repository

class FavoriteViewModel @ViewModelInject constructor(
    private val repository: Repository
): ViewModel() {

    val getFavoritesMovie = repository.favoriteRepository.getFavoriteMovies()

}