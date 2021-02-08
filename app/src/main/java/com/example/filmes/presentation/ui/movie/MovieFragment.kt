package com.example.filmes.presentation.ui.movie

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmes.R
import com.example.filmes.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : Fragment() {

    val adapter by lazy { MovieAdapter() }

    val movieViewModel: MovieViewModel by viewModels()

    lateinit var _bindingMovie: FragmentMovieBinding
    val bindingMovie: FragmentMovieBinding get() = _bindingMovie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _bindingMovie = FragmentMovieBinding.inflate(inflater, container, false)

        setupRecyclerView()

        requestApiMovie()

        adapter.addLoadStateListener { loadState ->
            bindingMovie.apply {
                progressBarMovie.isVisible = loadState.source.refresh is LoadState.Loading
                textInformation.isVisible = loadState.source.refresh is LoadState.Error
                buttonRetryAdapter.isVisible = loadState.source.refresh is LoadState.Error

                if (loadState.source.refresh is LoadState.Error) {
                    if (!movieViewModel.hasInternetConnection()) {
                        textInformation.text = getString(R.string.sem_acesso)
                    } else {
                        textInformation.text = getString(R.string.erro_desconhecido)
                    }
                }

                buttonRetryAdapter.setOnClickListener {
                    adapter.retry()
                }

            }
        }

        setHasOptionsMenu(true)

        return bindingMovie.root
    }

    private fun setupRecyclerView() {
        bindingMovie.recyclerViewMovie.adapter = adapter
    }

    private fun requestApiMovie() {
        movieViewModel.movies?.observe(viewLifecycleOwner) { response ->
            adapter.submitData(viewLifecycleOwner.lifecycle, response)
        }
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