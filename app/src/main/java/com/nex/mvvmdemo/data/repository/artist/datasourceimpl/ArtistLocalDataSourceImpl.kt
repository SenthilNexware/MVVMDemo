package com.nex.mvvmdemo.data.repository.artist.datasourceimpl

import com.nex.mvvmdemo.data.db.ArtistDao
import com.nex.mvvmdemo.data.model.artist.Artist
import com.nex.mvvmdemo.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistFromLocalDB(): List<Artist> {
       return artistDao.getArtists()
    }

    override suspend fun saveArtistToLocalDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artists)
        }
    }

    override suspend fun clearAllFromLocalDB() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteArtist()
        }
    }
}