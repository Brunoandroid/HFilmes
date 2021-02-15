package com.example.filmes.data.model.cast

import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("character")
    val character: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("profile_path")
    val profilePath: String
) {
    val baseUrlImage get() = "https://image.tmdb.org/t/p/w500"
}