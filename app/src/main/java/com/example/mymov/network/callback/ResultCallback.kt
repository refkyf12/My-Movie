package com.example.mymov.network.callback

import com.example.mymov.model.ApiResponse

interface ResultCallback : DataRepositoryCallback<ApiResponse?>{
    fun onShowLoading()
    fun onHideLoading()
}