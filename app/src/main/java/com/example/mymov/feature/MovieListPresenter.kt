package com.example.mymov.feature

import com.example.mymov.model.ApiResponse
import com.example.mymov.network.callback.DataRepositoryCallback
import com.example.mymov.network.callback.ResultCallback
import com.example.mymov.network.repository.DataRepository

class MovieListPresenter(private val view: ResultCallback, private val dataRepository: DataRepository) {
    fun getPopularMovie() {
        view.onShowLoading()
        dataRepository.getPopularMovie(object : DataRepositoryCallback<ApiResponse> {
            override fun onDataLoad(data: ApiResponse?) {
                view.onDataLoad(data)
                view.onHideLoading()
            }

            override fun onDataError(message: String?) {
                view.onDataError(message)
                view.onHideLoading()
            }
        })
    }

    fun getPlayingMovie() {
        view.onShowLoading()
        dataRepository.getPlayingMovie(object : DataRepositoryCallback<ApiResponse> {
            override fun onDataLoad(data: ApiResponse?) {
                view.onDataLoad(data)
                view.onHideLoading()
            }

            override fun onDataError(message: String?) {
                view.onDataError(message)
                view.onHideLoading()
            }
        })
    }
}