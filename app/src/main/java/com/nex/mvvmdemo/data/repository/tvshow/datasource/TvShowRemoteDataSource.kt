package com.nex.mvvmdemo.data.repository.tvshow.datasource


import com.nex.mvvmdemo.data.model.tvshows.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}