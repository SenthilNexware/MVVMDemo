package com.nex.mvvmdemo.presentation.di.core

import com.nex.mvvmdemo.presentation.di.artist.ArtistSubComponent
import com.nex.mvvmdemo.presentation.di.movies.MovieSubComponent
import com.nex.mvvmdemo.presentation.di.tvshow.TvShowsSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TvShowsSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
}