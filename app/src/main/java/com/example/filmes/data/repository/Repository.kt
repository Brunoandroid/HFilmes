package com.example.filmes.data.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    movieRepository: MovieRepository
) {

    val movieRepository = movieRepository

}