package com.example.filmes.data.service

import androidx.lifecycle.LiveData
import com.example.filmes.data.model.cast.CastCharacter
import com.example.filmes.data.model.movie.MovieResponse
import com.example.filmes.util.Constants.Companion.API_KEY
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RequestApi {

    @GET("movie/now_playing?api_key=$API_KEY")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int,
        @Query("language") language: String
    ): Response<MovieResponse>

    @GET("search/movie?api_key=$API_KEY")
    suspend fun getSearchMovie(
        @Query("page") page: Int,
        @Query("query") query: String,
        @Query("language") language: String
    ): Response<MovieResponse>

    @GET("movie/{movie_id}/credits?api_key=$API_KEY")
    suspend fun getCharactersMovie(
        @Path("movie_id") movie_id: Int
    ): Response<CastCharacter>
}