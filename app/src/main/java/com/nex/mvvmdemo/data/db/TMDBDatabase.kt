package com.nex.mvvmdemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nex.mvvmdemo.data.model.artist.Artist
import com.nex.mvvmdemo.data.model.movies.Movie
import com.nex.mvvmdemo.data.model.tvshows.TvShow

@Database(entities = [Movie::class,TvShow::class,Artist::class],version = 1,exportSchema = false)
abstract class TMDBDatabase :RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowsDao
    abstract fun artistDao(): ArtistDao
}