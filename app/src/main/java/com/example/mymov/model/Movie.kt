package com.example.mymov.model

import android.os.Parcel
import android.os.Parcelable

data class Movie (
    val id: String? = null,
    val title: String? = null,
    val overview: String? = null,
    val poster_path: String? = null,
    val popularity: String? = null,
    val vote_average: String? = null,
    val release_date: String? = null,
    val backdrop_path: String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(id)
        p0?.writeString(title)
        p0?.writeString(overview)
        p0?.writeString(poster_path)
        p0?.writeString(popularity)
        p0?.writeString(vote_average)
        p0?.writeString(release_date)
        p0?.writeString(backdrop_path)
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}