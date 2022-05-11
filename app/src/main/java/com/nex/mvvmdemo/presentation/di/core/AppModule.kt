package com.nex.mvvmdemo.presentation.di.core

import android.content.Context
import com.nex.mvvmdemo.presentation.di.artist.ArtistSubComponent
import com.nex.mvvmdemo.presentation.di.movies.MovieSubComponent
import com.nex.mvvmdemo.presentation.di.tvshow.TvShowsSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,TvShowsSubComponent::class,ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }



}