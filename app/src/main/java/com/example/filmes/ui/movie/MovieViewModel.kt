package com.example.filmes.ui.movie

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.example.filmes.data.repository.Repository


class MovieViewModel @ViewModelInject constructor(
    private val repository: Repository,
    application: Application,
    @Assisted state: SavedStateHandle
) : AndroidViewModel(application) {

    companion object {
        private const val CURRENT_QUERY = "current_query"
        private const val EMPTY_QUERY = ""
    }

    private val currentQuery = state.getLiveData(CURRENT_QUERY, EMPTY_QUERY)
    val movies = currentQuery.switchMap { query ->
        if (!query.isEmpty()) {
            repository.movieRepository.getSearchMovie(query, "pt-BR").asLiveData()
        } else {
            repository.movieRepository.getNowPlayingMovies("pt-BR").cachedIn(viewModelScope).asLiveData()
        }

    }

    fun getSearchMovie(query: String){
        currentQuery.value = query
    }

    // Verifica se tem internet
    fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

}