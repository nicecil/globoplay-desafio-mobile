package com.example.globoplay_desafio_mobile.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.globoplay_desafio_mobile.R
import com.example.globoplay_desafio_mobile.repository.MovieRepository
import com.example.globoplay_desafio_mobile.repository.MovieResponse
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), MovieRepository.MovieListListener {

    private lateinit var homeViewModel: HomeViewModel

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



        text_home.text = "HOME TEXT"

        return root
    }

    override fun onListFound(response: List<MovieResponse>?) {

    }

    override fun onGeneralError(message: String) {
    }
}