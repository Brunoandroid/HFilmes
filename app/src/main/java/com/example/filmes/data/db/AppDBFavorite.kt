package com.example.filmes.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(
    entities = [FavoriteMovie::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(TypesConverts::class)
abstract class AppDBFavorite: RoomDatabase() {

    abstract fun getFavoriteDao(): FavoriteDao

    }

