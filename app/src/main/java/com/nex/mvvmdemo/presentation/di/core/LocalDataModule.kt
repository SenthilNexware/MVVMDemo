package com.nex.mvvmdemo.presentation.di.core

import com.nex.mvvmdemo.data.db.ArtistDao
import com.nex.mvvmdemo.data.db.MovieDao
import com.nex.mvvmdemo.data.db.TvShowsDao
import com.nex.mvvmdemo.data.repository.artist.datasource.ArtistLocalDataSource
import com.nex.mvvmdemo.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.nex.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.nex.mvvmdemo.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.nex.mvvmdemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.nex.mvvmdemo.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistsLocalDataSource(artistDao: ArtistDao):ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowsLocalDataSource(tvShowsDao: TvShowsDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowsDao)
    }
}