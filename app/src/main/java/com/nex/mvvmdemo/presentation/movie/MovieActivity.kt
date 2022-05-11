package com.nex.mvvmdemo.presentation.movie

import android.annotation.SuppressLint
import android.database.DatabaseUtils
import android.opengl.Visibility
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
import com.nex.mvvmdemo.databinding.ActivityMovieBinding
import com.nex.mvvmdemo.presentation.di.injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    lateinit var movieViewModel: MovieViewModel
    lateinit var adapter: MovieAdapter
    lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as injector).createMovieSubComponent()
            .inject(this)
        movieViewModel =ViewModelProvider(this,factory).get(MovieViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.moviewRecyclerView.layoutManager=LinearLayoutManager(this)
        adapter= MovieAdapter()
        binding.moviewRecyclerView.adapter=adapter
        displayPopularMovies()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayPopularMovies(){
        binding.moviewProgressBar.visibility=View.VISIBLE
        val responseLiveData=movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.moviewProgressBar.visibility=View.GONE
            }else{
                binding.moviewProgressBar.visibility=View.GONE
                Toast.makeText(applicationContext,"No Data available",Toast.LENGTH_LONG).show()
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
        binding.moviewProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovieList()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.moviewProgressBar.visibility = View.GONE
            }else{
                binding.moviewProgressBar.visibility = View.GONE
            }
        })
    }
}