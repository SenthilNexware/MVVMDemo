package com.nex.mvvmdemo.presentation.di

import com.nex.mvvmdemo.presentation.di.artist.ArtistSubComponent
import com.nex.mvvmdemo.presentation.di.movies.MovieSubComponent
import com.nex.mvvmdemo.presentation.di.tvshow.TvShowsSubComponent

interface injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent(): TvShowsSubComponent
    fun createArtistsSubComponent(): ArtistSubComponent
}