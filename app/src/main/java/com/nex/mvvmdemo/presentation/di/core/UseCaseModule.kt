package com.nex.mvvmdemo.presentation.di.core

import com.nex.mvvmdemo.domain.repository.ArtistRepository
import com.nex.mvvmdemo.domain.repository.MovieRepository
import com.nex.mvvmdemo.domain.repository.TvShowsRepository
import com.nex.mvvmdemo.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository:  TvShowsRepository):GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowsRepository):UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistsUseCase(artistsRepository: ArtistRepository):GetArtistUseCase{
        return GetArtistUseCase(artistsRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistsRepository: ArtistRepository):UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistsRepository)
    }
}