package com.nex.mvvmdemo.presentation.tvShows

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
import com.nex.mvvmdemo.databinding.ActivityTvShowsBinding
import com.nex.mvvmdemo.presentation.di.injector
import com.nex.mvvmdemo.presentation.movie.MovieAdapter
import com.nex.mvvmdemo.presentation.movie.MovieViewModel
import com.nex.mvvmdemo.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class TvShowsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowsViewModelFactory
    lateinit var tvShowsViewModel: TvShowsViewModel
    lateinit var adapter:TvShowAdapter
    lateinit var binding :ActivityTvShowsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_tv_shows)
        (application as injector).createTvShowSubComponent()
            .inject(this)
        tvShowsViewModel = ViewModelProvider(this,factory).get(TvShowsViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.tvShowRecyclerView.layoutManager= LinearLayoutManager(this)
        adapter= TvShowAdapter()
        binding.tvShowRecyclerView.adapter=adapter
        displayPopularMovies()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayPopularMovies(){
        binding.tvShowRecyclerView.visibility= View.VISIBLE
        val responseLiveData=tvShowsViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility= View.GONE
            }else{
                binding.tvShowProgressBar.visibility= View.GONE
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
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val response = tvShowsViewModel.updateTvShows()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }else{
                binding.tvShowProgressBar.visibility = View.GONE
            }
        })
    }
}