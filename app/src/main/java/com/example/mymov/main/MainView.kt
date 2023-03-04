package com.example.mymov.main

import com.example.mymov.model.Movie

interface MainView {
    fun showMovieList(data: List<Movie>)
}