package com.nex.mvvmdemo.data.repository.movie.datasourceimpl

import com.nex.mvvmdemo.data.api.TMDBServices
import com.nex.mvvmdemo.data.model.movies.MovieList
import com.nex.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteSourceImpl(private val tmdbServices: TMDBServices,private val apiKey :String) :
    MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbServices.getPopularMovies(apiKey)

}