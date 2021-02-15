package com.example.filmes.data.db.favorite

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.filmes.data.model.movie.Movie
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity(tableName = "favorite_movie")
@Parcelize
data class FavoriteMovie(
   var movie: Movie
) : Serializable, Parcelable{
    @PrimaryKey (autoGenerate = true)
    var id : Int = 0
    val baseUrl get() = "https://image.tmdb.org/t/p/w500"
}