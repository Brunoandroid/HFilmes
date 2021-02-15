package com.example.filmes.data.model.cast

import com.google.gson.annotations.SerializedName

data class CastCharacter(
    @SerializedName("cast")
    val cast: List<Cast>,
    @SerializedName("id")
    val id: Int
)