package com.example.mymov.network

import com.example.mymov.BuildConfig.API_KEY
import com.example.mymov.BuildConfig.BASE_URL

object TMDBApi {
    fun getMovie(): String{
        return BASE_URL + API_KEY
    }
}