package com.example.globoplay_desafio_mobile.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.globoplay_desafio_mobile.R
import com.example.globoplay_desafio_mobile.repository.MovieRepository
import com.example.globoplay_desafio_mobile.repository.MovieResponse
import com.example.globoplay_desafio_mobile.ui.view.AdapterHomeFragmentRecyclerView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),
    MovieRepository.MovieListListener,
    AdapterHomeFragmentRecyclerView.MovieInterface {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(
            R.layout.fragment_home,
            container,
            false
        )

        var movieRepository: MovieRepository = MovieRepository()

        movieRepository.retrieveMovieDiscover(this)


        return root
    }

    override fun onListFound(response: List<MovieResponse>?) {

        val movieList: Array<MovieResponse>? = response?.toTypedArray()
        with(home_fragment_movie_recycler_view) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            movieList?.let {
                adapter = AdapterHomeFragmentRecyclerView(
                    movieList,
                    this@HomeFragment
                )
            }
        }
    }

    override fun onGeneralError(message: String) {
    }

    override fun onMovieClicked(movie: MovieResponse) {
//        Toast.makeText(this, movie.movieTitle, Toast.LENGTH_LONG).show()
    }
}