package com.nex.mvvmdemo.data.repository.tvshow.datasource


import com.nex.mvvmdemo.data.model.tvshows.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromLocalDB():List<TvShow>
    suspend fun saveTvShowsToLocalDB(tvShow:List<TvShow>)
    suspend fun clearAllFromLocalDB()
}