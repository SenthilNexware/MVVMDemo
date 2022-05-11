package com.nex.mvvmdemo.data.repository.movie.datasourceimpl

import com.nex.mvvmdemo.data.db.MovieDao
import com.nex.mvvmdemo.data.model.movies.Movie
import com.nex.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromLocalDB(): List<Movie> {
      return  movieDao.getMovies()
    }

    override suspend fun saveMoviesFromLocalDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAllFromLocalDB() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}