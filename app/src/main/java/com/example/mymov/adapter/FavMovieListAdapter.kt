package com.example.mymov.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymov.BuildConfig
import com.example.mymov.R
import com.example.mymov.model.Movie

class FavMovieListAdapter(private val context: Context?, private val items: List<Movie>?, private val listener: (Movie) -> Unit)
    : RecyclerView.Adapter<FavMovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_card_movie_popular,parent,false))
    }

    override fun getItemCount(): Int = items?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bindItem(items?.get(position), listener)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var moviePoster: ImageView = itemView.findViewById(R.id.movie_poster)
//        private var movieTitle: TextView = itemView.findViewById(R.id.movie_title)
        private var voteAverage: TextView = itemView.findViewById(R.id.vote_averagerv)
        var context = itemView.context

        fun bindItem(item: Movie?, listener: (Movie) -> Unit) {
            Glide.with(context)
                .load("${BuildConfig.URL_POSTER}${item?.poster_path}")
                .placeholder(ColorDrawable(Color.GRAY))
                .fallback(R.drawable.image_error_placeholder)
                .error(R.drawable.image_error_placeholder)
                .into(moviePoster)

            voteAverage.text = item?.vote_average

//            movieTitle.text = item?.title

            Log.d(MovieListAdapter::class.java.simpleName, "POSTER = ${item?.poster_path}")

            itemView.setOnClickListener {
                listener(item!!)
            }
        }
    }
}
