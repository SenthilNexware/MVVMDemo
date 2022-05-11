package com.nex.mvvmdemo.presentation.di.core

import com.nex.mvvmdemo.data.repository.artist.datasource.ArtistCacheDataSource
import com.nex.mvvmdemo.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.nex.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.nex.mvvmdemo.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.nex.mvvmdemo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.nex.mvvmdemo.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun providetvShowCacheDataSource():TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }
}