package com.example.globoplay_desafio_mobile.ui.home

import com.example.globoplay_desafio_mobile.repository.MovieResponse

interface HomeFragmentView {
    fun showLoading()
    fun hideLoading()

    fun getLayoutResource(): Int

    fun populateRecyclerView(movieList: Array<MovieResponse>?)
    fun showMovieDetailsActivity(movie: MovieResponse)

}
