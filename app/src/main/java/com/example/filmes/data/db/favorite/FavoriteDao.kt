package com.example.filmes.data.db.favorite

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.filmes.data.db.favorite.FavoriteMovie
import com.example.filmes.data.model.Movie

@Dao
interface FavoriteDao {

    @Insert
    suspend fun addToFavorite(favoriteMovie: FavoriteMovie)

    @Query("SELECT movie FROM favorite_movie")
    fun getFavorites(): LiveData<List<Movie>>

    @Query("SELECT count(*) FROM favorite_movie WHERE favorite_movie.movie = :movie")
    suspend fun checkMovie(movie: Movie): Int

   @Query("DELETE FROM favorite_movie WHERE favorite_movie.movie = :movie")
    suspend fun removeFromFavorite(movie: Movie) : Int
}