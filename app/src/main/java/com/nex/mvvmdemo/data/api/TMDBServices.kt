package com.nex.mvvmdemo.data.api


import com.nex.mvvmdemo.data.model.artist.ArtistList
import com.nex.mvvmdemo.data.model.movies.MovieList
import com.nex.mvvmdemo.data.model.tvshows.TvShowList
import retrofit2.Response
import retrofit2.http.GET

import retrofit2.http.Query


interface TMDBServices {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<ArtistList>
}