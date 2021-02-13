package com.example.filmes.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.filmes.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val args by navArgs<DetailsFragmentArgs>()

    val detailsViewModel: DetailsViewModel by viewModels()

    lateinit var _bindingDetails: FragmentDetailsBinding
    val bindingDetails: FragmentDetailsBinding get() = _bindingDetails

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _bindingDetails = FragmentDetailsBinding.inflate(inflater, container, false)

        val movie = args.movie
        bindingDetails.movie = movie

        var isToggleChecked = false

        lifecycleScope.launch {
            val countFavorite = detailsViewModel.checkMovie(movie)
            if (countFavorite > 0){
                bindingDetails.toggleFavorite.isChecked = true
                isToggleChecked = true
            } else {
                bindingDetails.toggleFavorite.isChecked = false
                isToggleChecked = false
            }
        }

        bindingDetails.toggleFavorite.setOnClickListener {
            isToggleChecked = !isToggleChecked
            if (isToggleChecked) {
                    detailsViewModel.addFavotite(movie)
            } else {
                detailsViewModel.remoteFromFavorite(movie)
            }

            bindingDetails.toggleFavorite.isChecked = isToggleChecked
        }

        return bindingDetails.root

    }
}