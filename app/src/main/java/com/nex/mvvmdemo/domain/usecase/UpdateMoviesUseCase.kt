package com.nex.mvvmdemo.domain.usecase

import com.nex.mvvmdemo.data.model.movies.Movie
import com.nex.mvvmdemo.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>?=movieRepository.updateMovies()
}