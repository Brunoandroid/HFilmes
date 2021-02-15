package com.example.filmes.data.model.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("results")
    val movies: List<Movie>

    )