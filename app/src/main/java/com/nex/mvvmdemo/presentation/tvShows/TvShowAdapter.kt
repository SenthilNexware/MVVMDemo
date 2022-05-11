package com.nex.mvvmdemo.presentation.tvShows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nex.mvvmdemo.R
import com.nex.mvvmdemo.data.model.movies.Movie
import com.nex.mvvmdemo.data.model.tvshows.TvShow
import com.nex.mvvmdemo.databinding.ListItemBinding

class TvShowAdapter():RecyclerView.Adapter<MyViewHolder>(){
    private val tvShowList=ArrayList<TvShow>()

    fun setList(movies:List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val layoutInflater=LayoutInflater.from(parent.context)
        val binding:ListItemBinding=DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
       return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class MyViewHolder(val binding:ListItemBinding)
    :RecyclerView.ViewHolder(binding.root){

       fun bind(tvShow: TvShow){
            binding.titleTextView.text=tvShow.name
           binding.descriptionTextView.text=tvShow.firstAirDate
           val posterUrl="https://image.tmdb.org/t/p/w500"+tvShow.posterPath
           Glide.with(binding.imageView.context)
               .load(posterUrl).into(binding.imageView)
        }

}