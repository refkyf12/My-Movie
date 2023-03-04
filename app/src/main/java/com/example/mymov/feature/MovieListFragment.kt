package com.example.mymov.feature


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.mymov.R
import com.example.mymov.adapter.MovieListAdapter
import com.example.mymov.model.ApiResponse
import com.example.mymov.network.callback.ResultCallback
import com.example.mymov.network.repository.DataRepository

class MovieListFragment() : Fragment(), ResultCallback {
    private lateinit var movieListPresenter: MovieListPresenter
    private lateinit var movieListAdapter: MovieListAdapter
    private lateinit var movieListRefresh: SwipeRefreshLayout
    private lateinit var rvMovieList: RecyclerView
    private lateinit var pbMovieList: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initComponents(view)
        movieListPresenter = MovieListPresenter(this, DataRepository())
        movieListPresenter.getPlayingMovie()

        movieListRefresh.setOnRefreshListener {
            movieListPresenter.getPlayingMovie()
            movieListRefresh.isRefreshing = false
        }
    }

    private fun initComponents(view: View) {
        rvMovieList = view.findViewById(R.id.rv_movie)
        movieListRefresh = view.findViewById(R.id.movie_refresh)
        pbMovieList = view.findViewById(R.id.pb_movie_list)
        rvMovieList.layoutManager = GridLayoutManager(context, 3)
    }

    private fun setAdapter(items: ApiResponse?) {
        movieListAdapter = MovieListAdapter(context, items?.results) {
            val intent = Intent(context, DetailMovieFragment::class.java)
            intent.putExtra("EXTRA_MOVIE", it)
            startActivity(intent)
        }
        rvMovieList.adapter = movieListAdapter
    }

    override fun onShowLoading() {
        pbMovieList.visibility = View.VISIBLE
    }

    override fun onHideLoading() {
        pbMovieList.visibility = View.GONE
    }

    override fun onDataLoad(data: ApiResponse?) {
        if(data != null){
            setAdapter(data)
            Log.d(MovieListFragment::class.java.simpleName, "DATA = ${data.toString()}")
        }
    }

    override fun onDataError(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
