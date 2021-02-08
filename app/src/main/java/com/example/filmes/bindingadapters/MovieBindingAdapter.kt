package com.example.filmes.bindingadapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.filmes.R

class MovieBindingAdapter {

    companion object {

        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(imagemView: ImageView, urlImageMovie: String) {
            Glide.with(imagemView)
                .load(urlImageMovie)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(imagemView)
        }

        @BindingAdapter("descriptionMovie")
        @JvmStatic
        fun textDescriptionMovie(textView: TextView, descriptionMovie: String) {
            if (descriptionMovie.isEmpty()){
                textView.text = textView.context.getString(R.string.descricao_movie_vazia)
            }else{
                textView.text = descriptionMovie
            }
        }

    }


}