package com.example.mymov.network

import com.example.mymov.model.ApiResponse
import com.example.mymov.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/popular?api_key=e1af79b45d25755115327eeb618e57b5")
    fun getPopularMovie(
        @Query("api_key") api_key: String?
    ) : Call<ApiResponse>

    @GET("3/movie/now_playing?api_key=e1af79b45d25755115327eeb618e57b5")
    fun getPlayingMovie(
        @Query("api_key") api_key: String?
    ) : Call<ApiResponse>

    @GET("3/movie/now_playing?api_key=e1af79b45d25755115327eeb618e57b5")
    fun getDetailMovie(
        @Query("api_key") api_key: String?
    ) : Call<ApiResponse>
}
