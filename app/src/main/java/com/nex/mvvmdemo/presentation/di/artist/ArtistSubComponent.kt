package com.nex.mvvmdemo.presentation.di.artist

import com.nex.mvvmdemo.presentation.artists.ArtistsActivity
import dagger.Subcomponent
import javax.inject.Inject

@ArtistScope
@Subcomponent(modules = [ArtistsModule::class])
interface ArtistSubComponent {
   fun inject(artistsActivity: ArtistsActivity)

   @Subcomponent.Factory
   interface Factory{
       fun create():ArtistSubComponent
   }
}