package com.nex.mvvmdemo.data.repository.movie.datasource

import com.nex.mvvmdemo.data.model.movies.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromLocalDB():List<Movie>
    suspend fun saveMoviesFromLocalDB(movies:List<Movie>)
    suspend fun clearAllFromLocalDB()
}