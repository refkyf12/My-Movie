package com.example.mymov.feature

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mymov.BuildConfig
import com.example.mymov.R
import com.example.mymov.model.ApiResponse
import com.example.mymov.model.Movie
import com.example.mymov.model.MovieDetail
import com.example.mymov.network.callback.ResultCallback
import com.example.mymov.network.repository.DataRepository
import kotlinx.android.synthetic.main.detail_movies.*

class DetailMovieFragment : AppCompatActivity() {
    private lateinit var detailMoviePresenter: DetailMoviePresenter
    private lateinit var pbdetailmovie: ProgressBar
    private lateinit var movieDetail: Movie
    private lateinit var detail_movie_bg: ImageView
    private lateinit var detail_movie_img: ImageView
    private lateinit var tv_title_movie_detail: TextView
    private lateinit var tv_detail_movie: TextView
    private lateinit var vote_average: TextView
    private lateinit var release_date: TextView

    private var detailMovieData: Movie?=null
    private var movieId: Int = 0


    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
    }


    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_movies)
        movieDetail = intent.getParcelableExtra("EXTRA_MOVIE" )!!
        initComponents()
    }


    private fun initComponents() {
        pbdetailmovie = findViewById(R.id.pb_detail_movie)
        tv_title_movie_detail = findViewById(R.id.tv_title_movie_detail)
        detail_movie_bg = findViewById(R.id.detail_movie_bg)
        detail_movie_img = findViewById(R.id.detail_movie_img)
        tv_detail_movie = findViewById(R.id.tv_detail_movie)
        vote_average = findViewById(R.id.vote_average)
        release_date = findViewById(R.id.release_date)

        release_date.text = movieDetail.release_date
        vote_average.text = movieDetail.vote_average
        tv_detail_movie.text = movieDetail.overview
        tv_title_movie_detail.text = movieDetail.title
        setImageMovie(movieDetail)
        setImageMoviePoster(movieDetail)

    }

    private fun setImageMovie(data: Movie) {
        Glide.with(this)
            .load("${BuildConfig.URL_POSTER}${data?.backdrop_path}")
            .placeholder(ColorDrawable(Color.GRAY))
            .fallback(R.drawable.image_error_placeholder)
            .error(R.drawable.image_error_placeholder)
            .into(detail_movie_bg)
    }

    private fun setImageMoviePoster(data: Movie) {
        Glide.with(this)
            .load("${BuildConfig.URL_POSTER}${data?.poster_path}")
            .placeholder(ColorDrawable(Color.GRAY))
            .fallback(R.drawable.image_error_placeholder)
            .error(R.drawable.image_error_placeholder)
            .into(detail_movie_img)
    }

}