package com.example.globoplay_desafio_mobile.ui.home

//
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.globoplay_desafio_mobile.R
import com.example.globoplay_desafio_mobile.repository.MovieResponse
import com.example.globoplay_desafio_mobile.ui.view.AdapterHomeFragmentRecyclerView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeFragmentView,
    AdapterHomeFragmentRecyclerView.MovieInterface {

    var eventHandler: HomeFragmentPresenterInterface? = null

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

        eventHandler = HomeFragmentPresenter(this)
        eventHandler?.attachView(this)
        eventHandler?.makeRequest()
        return root
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_home
    }

    override fun populateMovieRecyclerView(movieList: Array<MovieResponse>?) {
        with(home_fragment_movie_recycler_view) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            movieList?.let {
                adapter = AdapterHomeFragmentRecyclerView(
                    movieList,
                    this@HomeFragment
                )
            }
        }
    }

    override fun populateTvRecyclerView(tvList: Array<MovieResponse>?) {
        with(home_fragment_tv_recycler_view) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            tvList?.let {
                adapter = AdapterHomeFragmentRecyclerView(
                    tvList,
                    this@HomeFragment
                )
            }

        }
    }


    override fun onMovieClicked(movie: MovieResponse) {
//        Toast.makeText(this, movie.movieTitle, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        loading_layout?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading_layout?.visibility = View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG)
    }

    override fun showMovieDetailsActivity(movie: MovieResponse) {
    }
}