package com.example.filmes.data.paging

import androidx.paging.PagingSource
import com.example.filmes.data.service.MovieApi
import com.example.filmes.data.model.Movie
import retrofit2.HttpException
import java.io.IOException

private const val PAGE_INDEX = 1

class MoviePagingSource(
    private val movieApi: MovieApi,
    private val query: String?,
    private val language: String
) : PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {

        return try {
            val pagePosition = params.key ?: PAGE_INDEX
            val response = if(query != null) movieApi.getSearchMovie(pagePosition, query, language) else
                movieApi.getNowPlayingMovies(pagePosition, language)
            val movies = response.body()?.movies

            LoadResult.Page(
                data = movies!!,
                prevKey = if (pagePosition == PAGE_INDEX) null else pagePosition - 1,
                nextKey = if (movies.isEmpty()) null else pagePosition + 1
            )

        } catch (e: IOException){
            LoadResult.Error(e)
        } catch (e: HttpException){
            LoadResult.Error(e)
        }

    }
}
