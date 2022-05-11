package com.nex.mvvmdemo.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nex.mvvmdemo.domain.usecase.GetArtistUseCase
import com.nex.mvvmdemo.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistsUseCase
):ViewModel() {

    fun getArtists()= liveData {
        val artistsList=getArtistUseCase.execute()
        emit(artistsList)
    }

    fun updateArtist()= liveData {
        val artistsList=updateArtistUseCase.execute()
        emit(artistsList)
    }
}