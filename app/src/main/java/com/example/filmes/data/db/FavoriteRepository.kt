package com.example.filmes.data.db

import com.example.filmes.data.model.Movie
import javax.inject.Inject

class FavoriteRepository @Inject constructor(
    private val favoriteDao: FavoriteDao
) {

    suspend fun addToFavorite(favoriteMovie: FavoriteMovie) = favoriteDao.addToFavorite(favoriteMovie)
    fun getFavoriteMovies() = favoriteDao.getFavorite()
    suspend fun checkMovie(id: Int) = favoriteDao.checkMovie(id)
    suspend fun removeFromFavorite(id: Int){
        favoriteDao.removeFromFavorite(id)
    }

}