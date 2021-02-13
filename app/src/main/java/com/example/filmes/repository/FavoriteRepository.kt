package com.example.filmes.repository

import com.example.filmes.data.db.favorite.FavoriteDao
import com.example.filmes.data.db.favorite.FavoriteMovie
import com.example.filmes.data.model.Movie
import javax.inject.Inject

class FavoriteRepository @Inject constructor(
    private val favoriteDao: FavoriteDao
) {

    suspend fun addToFavorite(movie: Movie) = favoriteDao.addToFavorite(FavoriteMovie(movie))
    fun getFavoriteMovies() = favoriteDao.getFavorites()
    suspend fun checkMovie(movie: Movie) = favoriteDao.checkMovie(movie)
    suspend fun removeFromFavorite(movie: Movie){
        favoriteDao.removeFromFavorite(movie)
    }

}