package com.nex.mvvmdemo.data.repository.artist.datasourceimpl

import com.nex.mvvmdemo.data.api.TMDBServices
import com.nex.mvvmdemo.data.model.artist.Artist
import com.nex.mvvmdemo.data.model.artist.ArtistList
import com.nex.mvvmdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteSourceImpl(private val tmdbServices: TMDBServices, private val apiKey :String) :ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbServices.getPopularArtists(apiKey)
}