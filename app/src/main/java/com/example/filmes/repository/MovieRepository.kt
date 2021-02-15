package com.example.filmes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.filmes.data.model.cast.CastCharacter
import com.example.filmes.data.service.RequestApi
import com.example.filmes.data.paging.MoviePagingSource
import com.example.filmes.data.model.movie.Movie
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val requestApi: RequestApi) {

    fun getNowPlayingMovies(language: String): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5,
                maxSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(requestApi, null, language) }
        ).flow
    }

    fun getSearchMovie(query: String, language: String): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5,
                maxSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(requestApi, query, language) }
        ).flow
    }

    suspend fun getCharactersMovie(movie_id: Int): Response<CastCharacter>{
     return requestApi.getCharactersMovie(movie_id)
    }

}