package com.nex.mvvmdemo.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nex.mvvmdemo.R
import com.nex.mvvmdemo.databinding.ActivityHomeBinding
import com.nex.mvvmdemo.presentation.artists.ArtistsActivity
import com.nex.mvvmdemo.presentation.movie.MovieActivity
import com.nex.mvvmdemo.presentation.tvShows.TvShowsActivity


class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.buttonMovies.setOnClickListener {
            val intent= Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }
        binding.buttonArtists.setOnClickListener {
            val intent= Intent(this,ArtistsActivity::class.java)
            startActivity(intent)
        }
        binding.buttonTvShows.setOnClickListener {
            val intent= Intent(this,TvShowsActivity::class.java)
            startActivity(intent)
        }

    }
}