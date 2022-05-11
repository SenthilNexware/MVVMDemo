package com.nex.mvvmdemo.presentation.di.artist

import com.nex.mvvmdemo.domain.usecase.GetArtistUseCase
import com.nex.mvvmdemo.domain.usecase.UpdateArtistsUseCase
import com.nex.mvvmdemo.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistsModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModleFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ):ArtistsViewModelFactory{
          return ArtistsViewModelFactory(getArtistUseCase,updateArtistsUseCase)
    }
}