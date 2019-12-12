package com.example.globoplay_desafio_mobile.repository

import com.google.gson.annotations.SerializedName

data class MovieDiscoverResponse(
    @SerializedName("results") val movieList: List<MovieResponse>? = emptyList()
)

data class MovieResponse(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val movieTitle: String? = null,
    @SerializedName("original_title") val originalTitle: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("poster_path") val poster: String? = null,
    @SerializedName("vote_average") val voteAverage: Double? = null,
    @SerializedName("vote_count") val voteCount: Int? = null,
    @SerializedName("genre_ids") val genreIds: List<Int>? = emptyList()
)