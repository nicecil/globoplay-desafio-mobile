package com.example.globoplay_desafio_mobile.services

import com.example.globoplay_desafio_mobile.BuildConfig.API_KEY
import com.example.globoplay_desafio_mobile.repository.MovieDiscoverResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiInterface {
    @GET("discover/movie")
    fun getMovieRecommendations(
        @Query("api_key")
        api_key: String = API_KEY
    ): Call<MovieDiscoverResponse>

    @GET("discover/tv")
    fun getTVRecommendations(
        @Query("api_key")
        api_key: String = API_KEY
    ): Call<MovieDiscoverResponse>
}