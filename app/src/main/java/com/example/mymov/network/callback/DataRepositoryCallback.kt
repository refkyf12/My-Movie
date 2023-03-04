package com.example.mymov.network.callback

interface DataRepositoryCallback<T> {
    fun onDataLoad(data: T?)
    fun onDataError(message: String?)
}