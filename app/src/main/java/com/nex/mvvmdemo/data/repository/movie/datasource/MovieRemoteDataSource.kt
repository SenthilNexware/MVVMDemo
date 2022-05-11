package com.nex.mvvmdemo.data.repository.movie.datasource

import com.nex.mvvmdemo.data.model.movies.Movie
import com.nex.mvvmdemo.data.model.movies.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}