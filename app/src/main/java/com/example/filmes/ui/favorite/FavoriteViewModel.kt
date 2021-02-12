package com.example.filmes.ui.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.filmes.data.db.FavoriteRepository

class FavoriteViewModel @ViewModelInject constructor(
    private val repositoryFavorite: FavoriteRepository
): ViewModel() {

    val getFavoritesMovie = repositoryFavorite.getFavoriteMovies()

}