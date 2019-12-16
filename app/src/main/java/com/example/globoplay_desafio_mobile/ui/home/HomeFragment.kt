package com.example.globoplay_desafio_mobile.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.globoplay_desafio_mobile.R
import com.example.globoplay_desafio_mobile.repository.MovieRepository
import com.example.globoplay_desafio_mobile.repository.MovieResponse
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment(), MovieRepository.MovieListListener {


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

        val textView: TextView = root.findViewById(R.id.home_fragment_text_view)
        textView.text = "HOME TEXT"

        textView.setOnClickListener(View.OnClickListener {
            textView.text = "clicked"
            movieRepository.retrieveMovieDiscover(this)

        })

//        home_fragment_text_view.setText("HOME TEXT")

        return root
    }

    override fun onListFound(response: List<MovieResponse>?) {
        home_fragment_text_view.setText("GOT A LIST")
    }

    override fun onGeneralError(message: String) {
        home_fragment_text_view.text = "ERROR"
    }
}