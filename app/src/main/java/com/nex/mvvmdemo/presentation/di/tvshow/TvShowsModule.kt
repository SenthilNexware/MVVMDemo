package com.nex.mvvmdemo.presentation.di.tvshow

import com.nex.mvvmdemo.domain.usecase.GetArtistUseCase
import com.nex.mvvmdemo.domain.usecase.GetTvShowsUseCase
import com.nex.mvvmdemo.domain.usecase.UpdateArtistsUseCase
import com.nex.mvvmdemo.domain.usecase.UpdateTvShowsUseCase
import com.nex.mvvmdemo.presentation.artists.ArtistsViewModelFactory
import com.nex.mvvmdemo.presentation.tvShows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowsModule {
    @TvShowsScope
    @Provides
    fun provideArtistViewModleFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ):TvShowsViewModelFactory{
          return TvShowsViewModelFactory(getTvShowsUseCase,updateTvShowsUseCase)
    }
}