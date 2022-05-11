package com.nex.mvvmdemo.domain.repository

import com.nex.mvvmdemo.data.model.movies.Movie
import com.nex.mvvmdemo.data.model.tvshows.TvShow

interface TvShowsRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows():List<TvShow>?
}