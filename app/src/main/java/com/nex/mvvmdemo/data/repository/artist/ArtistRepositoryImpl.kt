package com.nex.mvvmdemo.data.repository.artist

import android.util.Log
import com.nex.mvvmdemo.data.model.artist.Artist

import com.nex.mvvmdemo.data.repository.artist.datasource.ArtistCacheDataSource
import com.nex.mvvmdemo.data.repository.artist.datasource.ArtistLocalDataSource
import com.nex.mvvmdemo.data.repository.artist.datasource.ArtistRemoteDataSource

import com.nex.mvvmdemo.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
    ) : ArtistRepository {

    override suspend fun getArtist(): List<Artist>? {
       return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListofArtist=getArtistFromCache()
        artistLocalDataSource.clearAllFromLocalDB()
        artistLocalDataSource.saveArtistToLocalDB(newListofArtist)
        artistCacheDataSource.saveArtistFromCache(newListofArtist)
        return newListofArtist
    }


    suspend fun getArtistFromAPI():List<Artist>{
        lateinit var artistsList:List<Artist>
        try {
            val response =artistRemoteDataSource.getArtists()
            val body=response.body()
            if(body!=null){
                artistsList=body.artists
            }

        }catch (ex:Exception){
            Log.i("MyTag",ex.message.toString())
        }

        return artistsList
    }


    suspend fun getArtistFromDB():List<Artist>{
        lateinit var artistsList:List<Artist>
        try {
            artistsList=artistLocalDataSource.getArtistFromLocalDB()
        }catch (ex:Exception){
            Log.i("MyTag",ex.message.toString())
        }
        if(artistsList.size>0){
            return artistsList
        }else{
            artistsList =getArtistFromAPI()
            artistLocalDataSource.saveArtistToLocalDB(artistsList)
        }
        return artistsList
    }


    suspend fun getArtistFromCache():List<Artist>{
        lateinit var artistsList:List<Artist>
        try {
            artistsList=artistCacheDataSource.getArtistFromCache()
        }catch (ex:Exception){
            Log.i("MyTag",ex.message.toString())
        }
        if(artistsList.size>0){
            return artistsList
        }else{
            artistsList =getArtistFromDB()
            artistLocalDataSource.saveArtistToLocalDB(artistsList)
        }
        return artistsList

    }

}