package com.nex.mvvmdemo.domain.usecase

import com.nex.mvvmdemo.data.model.artist.Artist
import com.nex.mvvmdemo.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>?=artistRepository.getArtist()
}