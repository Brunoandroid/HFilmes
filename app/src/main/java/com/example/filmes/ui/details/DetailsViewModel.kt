package com.example.filmes.ui.details

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.filmes.data.model.cast.CastCharacter
import com.example.filmes.data.model.movie.Movie
import com.example.filmes.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailsViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    val getCharactersMovie: MutableLiveData<Response<CastCharacter>> = MutableLiveData()

    suspend fun getCharactersMovie(movie_id: Int){
        getCharactersMovie.value = repository.movieRepository.getCharactersMovie(movie_id)
    }

    fun addFavotite(movie: Movie) {
        viewModelScope.launch {
            repository.favoriteRepository.addToFavorite(
               movie
            )
        }
    }

    suspend fun checkMovie(movie: Movie) = repository.favoriteRepository.checkMovie(movie)

    fun remoteFromFavorite(movie: Movie) {
        viewModelScope.launch {
            repository.favoriteRepository.removeFromFavorite(movie)
        }
    }
}

