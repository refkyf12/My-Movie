package com.example.mymov.network

import com.example.mymov.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class Retrofit {
    private val base_url = BuildConfig.BASE_URL
    val retrofit = Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build()

    val dataManager = retrofit.create(ApiService::class.java)
}