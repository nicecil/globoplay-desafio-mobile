package com.example.globoplay_desafio_mobile.ui.home

import android.widget.Toast
import com.example.globoplay_desafio_mobile.repository.MovieRepository
import com.example.globoplay_desafio_mobile.repository.MovieResponse

class HomeFragmentPresenter(val homeFragmentView: HomeFragmentView?) :
    HomeFragmentPresenterInterface, MovieRepository.MovieListListener {

    var view: HomeFragmentView? = null
    var movieRepository: MovieRepository? = null

    var movieList: Array<MovieResponse>? = null
    var tvList: Array<MovieResponse>? = null


    override fun attachView(homeFragmentView: HomeFragmentView) {
        view = homeFragmentView
    }

    override fun makeRequest() {
        movieRepository = MovieRepository()
        movieRepository?.retrieveMovieDiscover(this)
        movieRepository?.retrieveTvDiscover(this)
        view?.showLoading()
    }

    override fun onMovieListFound(response: List<MovieResponse>?) {
        movieList = response?.toTypedArray()
        view?.hideLoading()
        view?.populateMovieRecyclerView(movieList)
    }

    override fun onTvListFound(response: List<MovieResponse>?) {
        tvList = response?.toTypedArray()
        view?.hideLoading()
        view?.populateTvRecyclerView(tvList)
    }

    override fun onGeneralError(message: String) {
        view?.showError(message)
    }
}