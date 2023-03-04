package com.example.mymov.model

data class ApiResponse(
    val page: Int? = null,
    val total_results: Int? = null,
    val total_page: Int? = null,
    val results: List<Movie>? = null

)