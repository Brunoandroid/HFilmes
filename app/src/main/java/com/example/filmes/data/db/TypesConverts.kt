package com.example.filmes.data.db

import androidx.room.TypeConverter
import com.example.filmes.data.model.movie.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypesConverts {

    var gson = Gson()

    @TypeConverter
    fun movieToString(movie: Movie): String {
        return gson.toJson(movie)
    }

    @TypeConverter
    fun stringToMovie(data: String): Movie {
        val listType = object : TypeToken<Movie>() {}.type
        return gson.fromJson(data, listType)
    }

}