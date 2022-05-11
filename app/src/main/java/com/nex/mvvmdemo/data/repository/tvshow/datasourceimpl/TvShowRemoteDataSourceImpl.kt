package com.nex.mvvmdemo.data.repository.tvshow.datasourceimpl

import com.nex.mvvmdemo.data.api.TMDBServices
import com.nex.mvvmdemo.data.model.artist.ArtistList
import com.nex.mvvmdemo.data.model.tvshows.TvShowList
import com.nex.mvvmdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbServices: TMDBServices, private val apiKey :String) :TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> =tmdbServices.getPopularTvShows(apiKey)

}