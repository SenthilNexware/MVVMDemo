package com.nex.mvvmdemo.presentation.artists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nex.mvvmdemo.R
import com.nex.mvvmdemo.data.model.artist.Artist
import com.nex.mvvmdemo.data.model.movies.Movie
import com.nex.mvvmdemo.data.model.tvshows.TvShow
import com.nex.mvvmdemo.databinding.ListItemBinding

class ArtistsAdapter():RecyclerView.Adapter<MyViewHolder>(){
    private val artistsList=ArrayList<Artist>()

    fun setList(artist:List<Artist>){
        artistsList.clear()
        artistsList.addAll(artist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val layoutInflater=LayoutInflater.from(parent.context)
        val binding:ListItemBinding=DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
       return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistsList[position])
    }

    override fun getItemCount(): Int {
        return artistsList.size
    }
}

class MyViewHolder(val binding:ListItemBinding)
    :RecyclerView.ViewHolder(binding.root){

       fun bind(artist: Artist){
            binding.titleTextView.text=artist.name
           binding.descriptionTextView.visibility=View.GONE
         /*  binding.descriptionTextView.text=artist.popularity.toString()*/
           val posterUrl="https://image.tmdb.org/t/p/w500"+artist.profilePath
           Glide.with(binding.imageView.context)
               .load(posterUrl).into(binding.imageView)
        }

}