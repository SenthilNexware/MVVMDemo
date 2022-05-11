package com.nex.mvvmdemo.data.repository.tvshow.datasource

import com.nex.mvvmdemo.data.model.artist.Artist
import com.nex.mvvmdemo.data.model.tvshows.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>

    suspend fun saveTvShowsFromCache(tvShow:  List<TvShow>)
}