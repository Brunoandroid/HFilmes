package com.example.filmes.presentation.ui.favorite

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.filmes.R
import com.example.filmes.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    lateinit var _bindingFavorite: FragmentFavoriteBinding
    val bindingFavorite: FragmentFavoriteBinding get() = _bindingFavorite

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _bindingFavorite = FragmentFavoriteBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        return bindingFavorite.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar_movie, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }
}