package com.nex.mvvmdemo.data.repository.artist.datasourceimpl

import com.nex.mvvmdemo.data.model.artist.Artist
import com.nex.mvvmdemo.data.model.movies.Movie
import com.nex.mvvmdemo.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistsList =ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistsList
    }

    override suspend fun saveArtistFromCache(artists: List<Artist>) {
         artistsList.clear()
        artistsList= ArrayList(artists)
    }
}