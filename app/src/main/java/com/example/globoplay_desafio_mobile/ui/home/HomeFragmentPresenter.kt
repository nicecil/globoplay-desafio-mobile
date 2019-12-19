package com.example.globoplay_desafio_mobile.ui.home

import com.example.globoplay_desafio_mobile.repository.MovieRepository
import com.example.globoplay_desafio_mobile.repository.MovieResponse

class HomeFragmentPresenter(val homeFragmentView: HomeFragmentView?) :
    HomeFragmentPresenterInterface, MovieRepository.MovieListListener {

    var view: HomeFragmentView? = null
    var movieRepository: MovieRepository? = null

    var movieList: Array<MovieResponse>? = null


    override fun attachView(homeFragmentView: HomeFragmentView) {
        view = homeFragmentView
    }

    override fun makeRequest() {
        movieRepository = MovieRepository()
        movieRepository?.retrieveMovieDiscover(this)
        view?.showLoading()
    }

    override fun onListFound(response: List<MovieResponse>?) {
        movieList = response?.toTypedArray()
        view?.hideLoading()
        view?.populateRecyclerView(movieList)
    }

    override fun onGeneralError(message: String) {
    }
}