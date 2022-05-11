package com.nex.mvvmdemo.data.repository.movie.datasourceimpl

import com.nex.mvvmdemo.data.model.movies.Movie
import com.nex.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList =ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesFromCache(movies: List<Movie>) {
       movieList.clear()
        movieList=ArrayList(movies)
    }

}