package com.example.mymov.network.repository

import com.example.mymov.BuildConfig
import com.example.mymov.model.ApiResponse
import com.example.mymov.network.ApiService
import com.example.mymov.network.Retrofit
import com.example.mymov.network.callback.DataRepositoryCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository {

    val data: ApiService = Retrofit().dataManager
    val api_key = BuildConfig.API_KEY

    fun getPopularMovie(callback: DataRepositoryCallback<ApiResponse>) {
        data.getPopularMovie(api_key).enqueue(object: Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                callback.onDataError(t.message)
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                response.let {
                    if(it.isSuccessful) {
                        callback.onDataLoad(it.body())
                    } else {
                        callback.onDataError(it.errorBody().toString())
                    }
                }
            }
        })
    }

    fun getPlayingMovie(callback: DataRepositoryCallback<ApiResponse>) {
        data.getPlayingMovie(api_key).enqueue(object: Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                callback.onDataError(t.message)
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                response.let {
                    if(it.isSuccessful) {
                        callback.onDataLoad(it.body())
                    } else {
                        callback.onDataError(it.errorBody().toString())
                    }
                }
            }
        })
    }

    fun getDetailMovie(callback: DataRepositoryCallback<ApiResponse>) {
        data.getPlayingMovie(api_key).enqueue(object: Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                callback.onDataError(t.message)
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                response.let {
                    if(it.isSuccessful) {
                        callback.onDataLoad(it.body())
                    } else {
                        callback.onDataError(it.errorBody().toString())
                    }
                }
            }
        })
    }


}