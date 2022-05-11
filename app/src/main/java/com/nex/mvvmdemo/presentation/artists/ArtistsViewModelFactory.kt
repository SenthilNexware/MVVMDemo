package com.nex.mvvmdemo.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nex.mvvmdemo.domain.usecase.GetArtistUseCase
import com.nex.mvvmdemo.domain.usecase.UpdateArtistsUseCase

class ArtistsViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return ArtistViewModel(getArtistUseCase,updateArtistUseCase) as T
    }
}