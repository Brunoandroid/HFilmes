package com.example.filmes.ui.details

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.filmes.R

class DetailsBindingAdapter {

    companion object {

        @BindingAdapter("loadImageFavorite")
        @JvmStatic
        fun loadImageFavorite(imageView: ImageView, urlImage: String){
            Glide.with(imageView)
                .load(urlImage)
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(imageView)
        }

    }

}