package com.nex.mvvmdemo.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.nex.mvvmdemo.data.db.ArtistDao
import com.nex.mvvmdemo.data.db.MovieDao
import com.nex.mvvmdemo.data.db.TMDBDatabase
import com.nex.mvvmdemo.data.db.TvShowsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(content:Context):TMDBDatabase{
        return Room.databaseBuilder(content,TMDBDatabase::class.java,"tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase):ArtistDao {
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvshows(tmdbDatabase: TMDBDatabase):TvShowsDao {
        return tmdbDatabase.tvDao()
    }

}