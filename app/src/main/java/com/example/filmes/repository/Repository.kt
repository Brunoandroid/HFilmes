package com.example.filmes.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    movieRepository: MovieRepository,
    favoriteRepository: FavoriteRepository
) {

    val movieRepository = movieRepository
    val favoriteRepository = favoriteRepository

}