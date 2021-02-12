package com.example.filmes.data.db

import com.example.filmes.data.model.Movie
import javax.inject.Inject

class FavoriteRepository @Inject constructor(
    private val favoriteDao: FavoriteDao
) {

    suspend fun addToFavorite(movie: Movie) = favoriteDao.addToFavorite(FavoriteMovie(movie))
    fun getFavoriteMovies() = favoriteDao.getFavorite()
    suspend fun checkMovie(movie: Movie) = favoriteDao.checkMovie(movie)
    suspend fun removeFromFavorite(movie: Movie){
        favoriteDao.removeFromFavorite(movie)
    }

}