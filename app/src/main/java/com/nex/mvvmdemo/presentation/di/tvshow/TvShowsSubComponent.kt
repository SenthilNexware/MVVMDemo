package com.nex.mvvmdemo.presentation.di.tvshow

import com.nex.mvvmdemo.presentation.artists.ArtistsActivity
import com.nex.mvvmdemo.presentation.tvShows.TvShowsActivity
import dagger.Subcomponent

@TvShowsScope
@Subcomponent(modules = [TvShowsModule::class])
interface TvShowsSubComponent {
   fun inject(tvShowsActivity: TvShowsActivity)

   @Subcomponent.Factory
   interface Factory{
       fun create():TvShowsSubComponent
   }
}