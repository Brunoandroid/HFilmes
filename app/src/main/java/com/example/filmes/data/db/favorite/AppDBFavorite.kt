package com.example.filmes.data.db.favorite

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.filmes.data.db.TypesConverts


@Database(
    entities = [FavoriteMovie::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(TypesConverts::class)
abstract class AppDBFavorite: RoomDatabase() {

    abstract fun getFavoriteDao(): FavoriteDao

    }

