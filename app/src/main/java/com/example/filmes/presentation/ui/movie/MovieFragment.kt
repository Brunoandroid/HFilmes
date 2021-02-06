package com.example.filmes.presentation.ui.movie

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.filmes.R
import com.example.filmes.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {

    lateinit var _bindingMovie: FragmentMovieBinding
    val bindingMovie: FragmentMovieBinding get() = _bindingMovie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _bindingMovie = FragmentMovieBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        bindingMovie.recyclerViewMovie.showShimmer()

        return bindingMovie.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar_movie, menu)

        val search = menu.findItem(R.id.searchMovie)
        val searchView = search.actionView as androidx.appcompat.widget.SearchView
        searchView.queryHint = "Digite o nome do filme"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Code
                return true
            }

        })
        super.onCreateOptionsMenu(menu, inflater)
    }

}