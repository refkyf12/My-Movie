package com.example.mymov

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mymov.about.AboutActivity
import com.example.mymov.adapter.MainPagerAdapter
import com.example.mymov.feature.MovieListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // val navView: BottomNavigationView = findViewById(R.id.nav_view)

//        supportFragmentManager.beginTransaction().add(R.id.main_fragment, MovieListFragment(supportFragmentManager)).commit()
        main_toolbar.setTitle("MyMovie")
        setSupportActionBar(main_toolbar)

        val fragmentAdapter = MainPagerAdapter(supportFragmentManager)
        view_pager.adapter = fragmentAdapter

        tabs.setupWithViewPager(view_pager)

        val btnAbout = findViewById<ImageView>(R.id.btn_about)

        btnAbout.setOnClickListener{
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_fragment) as NavHostFragment
        val navController = navHostFragment.navController

//        val navController = findNavController(R.id.main_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
       // navView.setupWithNavController(navController)
    }
}
