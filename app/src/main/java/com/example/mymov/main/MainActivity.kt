package com.example.mymov.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mymov.R
import com.example.mymov.about.AboutActivity
import com.example.mymov.feature.MovieListPresenter
import com.example.mymov.model.ApiResponse
import com.example.mymov.model.Movie
import com.example.mymov.network.callback.ResultCallback
import com.example.mymov.network.repository.DataRepository

class MainActivity : AppCompatActivity(), ResultCallback{
    private lateinit var listMovie : RecyclerView
    private var movies: MutableList<Movie> = mutableListOf()
    private lateinit var mainPresenter: MovieListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter =
            MovieListPresenter(this, DataRepository())
        mainPresenter.getPopularMovie()
        mainPresenter.getPlayingMovie()


    }

    override fun onShowLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onHideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDataLoad(data: ApiResponse?) {
        return
    }

    override fun onDataError(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}