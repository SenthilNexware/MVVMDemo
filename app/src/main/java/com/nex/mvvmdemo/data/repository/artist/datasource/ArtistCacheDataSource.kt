package com.nex.mvvmdemo.data.repository.artist.datasource

import com.nex.mvvmdemo.data.model.artist.Artist


interface ArtistCacheDataSource {

    suspend fun getArtistFromCache():List<Artist>

    suspend fun saveArtistFromCache(artists: List<Artist>)
}