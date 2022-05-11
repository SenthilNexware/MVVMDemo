package com.nex.mvvmdemo.domain.repository

import com.nex.mvvmdemo.data.model.movies.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies():List<Movie>?
}