package com.nex.mvvmdemo.data.repository.artist.datasource

import com.nex.mvvmdemo.data.model.artist.Artist
import com.nex.mvvmdemo.data.model.movies.Movie

interface ArtistLocalDataSource  {
    suspend fun getArtistFromLocalDB():List<Artist>
    suspend fun saveArtistToLocalDB(artist:List<Artist>)
    suspend fun clearAllFromLocalDB()
}