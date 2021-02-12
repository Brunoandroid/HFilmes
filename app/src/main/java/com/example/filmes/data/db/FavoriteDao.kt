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

    @Query("SELECT * FROM favorite_movie")
    fun getFavorite(): LiveData<List<FavoriteMovie>>

    @Query("SELECT count(*) FROM favorite_movie WHERE favorite_movie.id_movie = :id")
    suspend fun checkMovie(id: Int): Int

    @Query("DELETE FROM favorite_movie WHERE favorite_movie.id_movie = :id")
    suspend fun removeFromFavorite(id: Int) : Int
}