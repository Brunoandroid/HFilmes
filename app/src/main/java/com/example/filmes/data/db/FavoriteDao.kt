package com.example.filmes.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.filmes.data.model.Movie

@Dao
interface FavoriteDao {

    @Insert
    suspend fun addToFavorite(favoriteMovie: FavoriteMovie)

    @Query("SELECT movie FROM favorite_movie")
    fun getFavorite(): LiveData<List<Movie>>

    @Query("SELECT count(*) FROM favorite_movie WHERE favorite_movie.movie = :movie")
    suspend fun checkMovie(movie: Movie): Int

   @Query("DELETE FROM favorite_movie WHERE favorite_movie.movie = :movie")
    suspend fun removeFromFavorite(movie: Movie) : Int
}