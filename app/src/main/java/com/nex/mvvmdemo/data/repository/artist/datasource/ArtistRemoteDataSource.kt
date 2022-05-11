package com.nex.mvvmdemo.data.repository.artist.datasource

import com.nex.mvvmdemo.data.model.artist.Artist
import com.nex.mvvmdemo.data.model.artist.ArtistList
import com.nex.mvvmdemo.data.model.movies.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}