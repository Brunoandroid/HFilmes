package com.example.filmes.data.paging

import android.util.Log
import androidx.paging.PagingSource
import com.example.filmes.data.api.MovieApi
import com.example.filmes.models.Movie
import retrofit2.HttpException
import java.io.IOException

private const val PAGE_INDEX = 1

class MoviePagingSource(
    private val movieApi: MovieApi,
    private val language: String
) : PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {

        return try {
            val pagePosition = params.key ?: PAGE_INDEX
            val response = movieApi.getNowPlayingMovies(pagePosition, language)
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
