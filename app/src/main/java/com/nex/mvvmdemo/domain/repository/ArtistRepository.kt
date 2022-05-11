package com.nex.mvvmdemo.domain.repository

import com.nex.mvvmdemo.data.model.artist.Artist
import com.nex.mvvmdemo.data.model.tvshows.TvShow

interface ArtistRepository {
    suspend fun getArtist(): List<Artist>?

    suspend fun updateArtist():List<Artist>?
}