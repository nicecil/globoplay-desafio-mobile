package com.example.globoplay_desafio_mobile.ui.home

import com.example.globoplay_desafio_mobile.repository.MovieResponse

interface HomeFragmentView {
    fun showLoading()
    fun hideLoading()

    fun showError(message: String)

    fun getLayoutResource(): Int

    fun populateMovieRecyclerView(movieList: Array<MovieResponse>?)

    fun populateTvRecyclerView(tvList: Array<MovieResponse>?)

    fun showMovieDetailsActivity(movie: MovieResponse)

}
