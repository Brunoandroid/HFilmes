package com.example.filmes.ui.details

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmes.data.model.cast.Cast
import com.example.filmes.databinding.RowCharacterMovieBinding

class DetailsCharactersAdapter : RecyclerView.Adapter<DetailsCharactersAdapter.DetailsCharactersViewHolder>() {

    var list: List<Cast> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsCharactersViewHolder {
        val binding =
            RowCharacterMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailsCharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailsCharactersViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class DetailsCharactersViewHolder(private val binding: RowCharacterMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bind(cast: Cast){
            binding.cast = cast
            binding.rowCharacters.setOnClickListener{
                Log.d("Click:", cast.name)
            }
        }

    }

    override fun getItemCount(): Int = list.size

    fun setListCharacters(listCast: List<Cast>){
        this.list = listCast
        notifyDataSetChanged()
    }
}