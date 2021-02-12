package com.example.filmes.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.filmes.data.model.Movie

@Database(entities = [FavoriteMovie::class], version = 2)
abstract class AppDBFavorite: RoomDatabase() {
    abstract fun getFavoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var instance: AppDBFavorite? = null

        fun getDatabase(context: Context): AppDBFavorite =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDBFavorite::class.java, "db_favorite")
                .fallbackToDestructiveMigration()
                .build()

    }

}