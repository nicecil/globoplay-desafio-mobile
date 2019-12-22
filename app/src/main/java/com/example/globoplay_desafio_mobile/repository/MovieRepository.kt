package com.example.globoplay_desafio_mobile.repository

import com.example.globoplay_desafio_mobile.services.MovieAPI
import com.example.globoplay_desafio_mobile.services.base.BaseCallback
import retrofit2.Call
import retrofit2.Response

class MovieRepository {
    var apiMovie: MovieAPI? = null

    init {
        apiMovie = MovieAPI()
    }

    fun retrieveMovieDiscover(listener: MovieListListener) {
        apiMovie?.getMovieDiscover(object : BaseCallback<MovieDiscoverResponse> {
            override fun onResponse(response: Response<MovieDiscoverResponse>) {
                val statusCode = response.code()
                val body = response.body()

                when (statusCode) {
                    StatusCode.SUCCESS.value -> {
                        listener.onMovieListFound(body?.movieList)
                    }
                    else -> {
                        listener.onGeneralError("Erro na chamada da rota /discover/movie")
                    }
                }

            }

            override fun onGeneralError(call: Call<MovieDiscoverResponse>, t: Throwable) {
                listener.onGeneralError("Erro na chamada da API")
            }

        })
    }

    fun retrieveTvDiscover(listener: MovieListListener) {
        apiMovie?.getTvDiscover(object : BaseCallback<MovieDiscoverResponse> {
            override fun onResponse(response: Response<MovieDiscoverResponse>) {
                val statusCode = response.code()
                val body = response.body()

                when (statusCode) {
                    StatusCode.SUCCESS.value -> {
                        listener.onTvListFound(body?.movieList)
                    }
                    else -> {
                        listener.onGeneralError("Erro na chamada da rota /discover/tv")
                    }
                }
            }

            override fun onGeneralError(call: Call<MovieDiscoverResponse>, t: Throwable) {
                listener.onGeneralError("Erro na chamada da API")
            }

        })
    }

    interface MovieListListener {
        fun onMovieListFound(response: List<MovieResponse>? = emptyList())

        fun onTvListFound(response: List<MovieResponse>? = emptyList())

        fun onGeneralError(message: String)
    }

    enum class StatusCode(val value: Int) {
        SUCCESS(200),
        UNAVAILABLE(404),
        SERVER_ERROR(500)

    }
}