package com.example.filmes.ui.favorite

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.filmes.R
import com.example.filmes.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    val adapter by lazy { FavoriteAdapter() }
    val favoriteViewModel: FavoriteViewModel by viewModels()

    lateinit var _bindingFavorite: FragmentFavoriteBinding
    val bindingFavorite: FragmentFavoriteBinding get() = _bindingFavorite

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _bindingFavorite = FragmentFavoriteBinding.inflate(inflater, container, false)

        bindingFavorite.recyclerFavorite

        setupRecyclerView()

        getFavoritesMovie()

        setHasOptionsMenu(true)

        return bindingFavorite.root

    }

    private fun setupRecyclerView() {
        bindingFavorite.recyclerFavorite.adapter = adapter
    }

    private fun getFavoritesMovie() {
        favoriteViewModel.getFavoritesMovie.observe(viewLifecycleOwner){ movie ->
            adapter.setMovieList(movie)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar_movie, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }
}