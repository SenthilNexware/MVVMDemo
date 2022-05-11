package com.nex.mvvmdemo.data.repository.tvshow.datasourceimpl

import com.nex.mvvmdemo.data.db.ArtistDao
import com.nex.mvvmdemo.data.db.TvShowsDao
import com.nex.mvvmdemo.data.model.tvshows.TvShow
import com.nex.mvvmdemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.TlsVersion

class TvShowLocalDataSourceImpl(private val tvShowsDao: TvShowsDao) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromLocalDB(): List<TvShow> {
        return tvShowsDao.getTvShows()
    }

    override suspend fun saveTvShowsToLocalDB(tvShows: List<TvShow>) {
       CoroutineScope(Dispatchers.IO).launch {
           tvShowsDao.saveTvShows(tvShows)
       }
    }

    override suspend fun clearAllFromLocalDB() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.deleteTvShows()
        }
    }
}