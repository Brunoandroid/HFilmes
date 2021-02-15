package com.example.filmes.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.filmes.data.model.movie.Movie
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

            binding.rowItemMovie.setOnClickListener {
                val action = FavoriteFragmentDirections.actionFavoriteFragmentToDetailsFragment(movie)
                binding.rowItemMovie.findNavController().navigate(action)
            }

        }
    }

    override fun getItemCount(): Int = list.size

    fun setMovieList(list: List<Movie>){
        this.list = list
        notifyDataSetChanged()
    }

}