package com.nex.mvvmdemo.presentation.di.core

import com.nex.mvvmdemo.data.api.TMDBServices
import com.nex.mvvmdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.nex.mvvmdemo.data.repository.artist.datasourceimpl.ArtistRemoteSourceImpl
import com.nex.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.nex.mvvmdemo.data.repository.movie.datasourceimpl.MovieRemoteSourceImpl
import com.nex.mvvmdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.nex.mvvmdemo.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbServices: TMDBServices):MovieRemoteDataSource{
        return MovieRemoteSourceImpl(tmdbServices,apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbServices: TMDBServices):TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmdbServices,apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbServices: TMDBServices):ArtistRemoteDataSource{
        return ArtistRemoteSourceImpl(tmdbServices,apiKey)
    }
}