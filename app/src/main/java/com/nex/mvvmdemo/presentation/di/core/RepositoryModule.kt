package com.nex.mvvmdemo.presentation.di.core

import com.nex.mvvmdemo.data.repository.artist.ArtistRepositoryImpl
import com.nex.mvvmdemo.data.repository.artist.datasource.ArtistCacheDataSource
import com.nex.mvvmdemo.data.repository.artist.datasource.ArtistLocalDataSource
import com.nex.mvvmdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.nex.mvvmdemo.data.repository.movie.MovieRepositoryImpl
import com.nex.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.nex.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.nex.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.nex.mvvmdemo.data.repository.tvshow.TvShowRepositoryImpl
import com.nex.mvvmdemo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.nex.mvvmdemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.nex.mvvmdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.nex.mvvmdemo.domain.repository.ArtistRepository
import com.nex.mvvmdemo.domain.repository.MovieRepository
import com.nex.mvvmdemo.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ):MovieRepository{
        return MovieRepositoryImpl(movieRemoteDataSource,movieLocalDataSource,movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistsRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ):ArtistRepository{
        return ArtistRepositoryImpl(artistRemoteDataSource,artistLocalDataSource,artistCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowsRepository(
       tvShowRemoteDataSource: TvShowRemoteDataSource,
       tvShowLocalDataSource: TvShowLocalDataSource,
       tvShowCacheDataSource: TvShowCacheDataSource
    ):TvShowsRepository{
        return TvShowRepositoryImpl(tvShowRemoteDataSource,tvShowLocalDataSource,tvShowCacheDataSource)
    }
}