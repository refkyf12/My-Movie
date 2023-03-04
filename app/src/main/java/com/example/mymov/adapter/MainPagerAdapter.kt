package com.example.mymov.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mymov.feature.FavMovieListFragment
import com.example.mymov.feature.MovieListFragment

class MainPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
            return when(position) {
                0-> {
                    MovieListFragment()
            }
                else -> {
                    FavMovieListFragment()
                }
            }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0-> "NOW PLAYING"
            else ->  {
                return "POPULAR"
            }
        }
    }
}