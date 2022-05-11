package com.nex.mvvmdemo.data.repository.tvshow

import android.util.Log
import com.nex.mvvmdemo.data.model.artist.Artist
import com.nex.mvvmdemo.data.model.tvshows.TvShow
import com.nex.mvvmdemo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.nex.mvvmdemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.nex.mvvmdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.nex.mvvmdemo.domain.repository.TvShowsRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListofTvShows=getTvShowsFromCache()
        tvShowLocalDataSource.clearAllFromLocalDB()
        tvShowLocalDataSource.saveTvShowsToLocalDB(newListofTvShows)
        tvShowCacheDataSource.saveTvShowsFromCache(newListofTvShows)
        return newListofTvShows
    }


    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var tvShowsList:List<TvShow>
        try {
            val response =tvShowRemoteDataSource.getTvShows()
            val body=response.body()
            if(body!=null){
                tvShowsList=body.tvShows
            }

        }catch (ex:Exception){
            Log.i("MyTag",ex.message.toString())
        }

        return tvShowsList
    }


    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowsList:List<TvShow>
        try {
            tvShowsList=tvShowLocalDataSource.getTvShowsFromLocalDB()
        }catch (ex:Exception){
            Log.i("MyTag",ex.message.toString())
        }
        if(tvShowsList.size>0){
            return tvShowsList
        }else{
            tvShowsList =getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToLocalDB(tvShowsList)
        }
        return tvShowsList
    }


    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowsList:List<TvShow>
        try {
            tvShowsList=tvShowLocalDataSource.getTvShowsFromLocalDB()
        }catch (ex:Exception){
            Log.i("MyTag",ex.message.toString())
        }
        if(tvShowsList.size>0){
            return tvShowsList
        }else{
            tvShowsList =getTvShowsFromDB()
            tvShowLocalDataSource.saveTvShowsToLocalDB(tvShowsList)
        }
        return tvShowsList

    }
}