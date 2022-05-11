package com.nex.mvvmdemo.presentation.di.movies

import com.nex.mvvmdemo.domain.usecase.GetArtistUseCase
import com.nex.mvvmdemo.domain.usecase.GetMoviesUseCase
import com.nex.mvvmdemo.domain.usecase.UpdateArtistsUseCase
import com.nex.mvvmdemo.domain.usecase.UpdateMoviesUseCase
import com.nex.mvvmdemo.presentation.artists.ArtistsViewModelFactory
import com.nex.mvvmdemo.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideArtistViewModleFactory(
         getMoviesUseCase: GetMoviesUseCase,
         updateMoviesUseCase: UpdateMoviesUseCase
    ):MovieViewModelFactory{
          return MovieViewModelFactory(getMoviesUseCase,updateMoviesUseCase)
    }
}