package com.nex.mvvmdemo.data.repository.tvshow.datasourceimpl

import com.nex.mvvmdemo.data.model.artist.Artist
import com.nex.mvvmdemo.data.model.tvshows.TvShow
import com.nex.mvvmdemo.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList =ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsFromCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList=ArrayList(tvShows)
    }
}