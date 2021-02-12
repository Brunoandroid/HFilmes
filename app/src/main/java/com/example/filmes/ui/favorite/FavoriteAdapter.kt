package com.example.filmes.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmes.data.db.FavoriteMovie
import com.example.filmes.data.model.Movie
import com.example.filmes.databinding.RowMovieItemBinding

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private var list: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding =
            RowMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class FavoriteViewHolder(private val binding: RowMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
        }
    }

    override fun getItemCount(): Int = list.size

    fun setMovieList(list: List<Movie>){
        this.list = list
        notifyDataSetChanged()
    }

}