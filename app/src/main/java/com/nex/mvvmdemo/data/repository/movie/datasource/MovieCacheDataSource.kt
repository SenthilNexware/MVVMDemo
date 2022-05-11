package com.nex.mvvmdemo.data.repository.movie.datasource

import com.nex.mvvmdemo.data.model.movies.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache():List<Movie>

    suspend fun saveMoviesFromCache(movie: List<Movie>)
}