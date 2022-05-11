package com.nex.mvvmdemo.presentation

import android.app.Application
import com.nex.mvvmdemo.BuildConfig


import com.nex.mvvmdemo.presentation.di.artist.ArtistSubComponent
import com.nex.mvvmdemo.presentation.di.core.*
import com.nex.mvvmdemo.presentation.di.injector
import com.nex.mvvmdemo.presentation.di.movies.MovieSubComponent
import com.nex.mvvmdemo.presentation.di.tvshow.TvShowsSubComponent


class App : Application(),injector {
    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent= DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
       return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowsSubComponent {
       return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistsSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}