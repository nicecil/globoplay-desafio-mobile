package com.example.globoplay_desafio_mobile.services

import com.example.globoplay_desafio_mobile.repository.MovieDiscoverResponse
import com.example.globoplay_desafio_mobile.services.base.BaseCallback
import com.example.globoplay_desafio_mobile.services.retrofit.RetrofitUtil
import retrofit2.Call
import retrofit2.Response

class MovieAPI {
    fun getMovieDiscover(callback: BaseCallback<MovieDiscoverResponse>) {
        val movieAPI = RetrofitUtil().api().create(MovieApiInterface::class.java)

        val call = movieAPI.getMovieRecommendations()

        call.enqueue(object : retrofit2.Callback<MovieDiscoverResponse> {
            override fun onFailure(call: Call<MovieDiscoverResponse>, t: Throwable) {
                callback.onGeneralError(call, t)
            }

            override fun onResponse(
                call: Call<MovieDiscoverResponse>,
                response: Response<MovieDiscoverResponse>
            ) {
                callback.onResponse(response)
            }

        })
    }

    fun getTvDiscover(callback: BaseCallback<MovieDiscoverResponse>) {
        val tvAPI = RetrofitUtil().api().create(MovieApiInterface::class.java)

        val call = tvAPI.getTVRecommendations()

        call.enqueue(object: retrofit2.Callback<MovieDiscoverResponse> {
            override fun onFailure(call: Call<MovieDiscoverResponse>, t:Throwable) {
                callback.onGeneralError(call, t)
            }

            override fun onResponse(
                call: Call<MovieDiscoverResponse>,
                response: Response<MovieDiscoverResponse>
            ) {
                callback.onResponse(response)
            }
        })
    }
}