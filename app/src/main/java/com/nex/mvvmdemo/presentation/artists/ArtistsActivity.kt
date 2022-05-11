package com.nex.mvvmdemo.presentation.artists

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nex.mvvmdemo.R
import com.nex.mvvmdemo.databinding.ActivityArtistsBinding
import com.nex.mvvmdemo.presentation.di.injector
import com.nex.mvvmdemo.presentation.tvShows.TvShowAdapter
import com.nex.mvvmdemo.presentation.tvShows.TvShowsViewModel
import com.nex.mvvmdemo.presentation.tvShows.TvShowsViewModelFactory
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistsViewModelFactory
    lateinit var artistViewModel: ArtistViewModel
    lateinit var adapter:ArtistsAdapter
    lateinit var binding: ActivityArtistsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_artists)
        (application as injector).createArtistsSubComponent()
            .inject(this)
        artistViewModel = ViewModelProvider(this,factory).get(ArtistViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.artistsRecyclerView.layoutManager= LinearLayoutManager(this)
        adapter= ArtistsAdapter()
        binding.artistsRecyclerView.adapter=adapter
        displayPopularMovies()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayPopularMovies(){
        binding.artistsRecyclerView.visibility= View.VISIBLE
        val responseLiveData=artistViewModel.getArtists()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistsProgressBar.visibility= View.GONE
            }else{
                binding.artistsProgressBar.visibility= View.GONE
                Toast.makeText(applicationContext,"No Data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateMovies(){
        binding.artistsProgressBar.visibility = View.VISIBLE
        val response = artistViewModel.updateArtist()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistsProgressBar.visibility = View.GONE
            }else{
                binding.artistsProgressBar.visibility = View.GONE
            }
        })
    }
}