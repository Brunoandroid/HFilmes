package com.example.filmes.data.api

import com.example.filmes.models.MovieResponse
import com.example.filmes.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

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
}