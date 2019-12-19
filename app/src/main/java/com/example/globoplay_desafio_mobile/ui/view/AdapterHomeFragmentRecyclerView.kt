package com.example.globoplay_desafio_mobile.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.globoplay_desafio_mobile.BuildConfig.BASE_IMAGE_URL
import com.example.globoplay_desafio_mobile.R
import com.example.globoplay_desafio_mobile.repository.MovieResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_viewholder_home_fragment_list.view.*

class AdapterHomeFragmentRecyclerView(
    private val movieList: Array<MovieResponse>,
    movieInterface: MovieInterface
) : RecyclerView.Adapter<AdapterHomeFragmentRecyclerView.ViewHolderMovies>() {

    var movieInterface: MovieInterface? = null

    init {
        this.movieInterface = movieInterface
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovies {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.layout_viewholder_home_fragment_list,
                parent, false
            ) as View
        return ViewHolderMovies(view)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(
        holder: AdapterHomeFragmentRecyclerView.ViewHolderMovies,
        position: Int
    ) {
        val baseUrl = BASE_IMAGE_URL
        val imageUrl = movieList[position].poster
        holder.apply {
            Picasso.get()
                .load(baseUrl + imageUrl)
                .centerCrop()
                .fit()
                .into(moviePoster)
        }
    }

    class ViewHolderMovies(val view: View) : RecyclerView.ViewHolder(view) {
        val moviePoster = view.layout_viewholder_home_fragment_image_view
    }

    interface MovieInterface {
        fun onMovieClicked(movie: MovieResponse)
    }

}