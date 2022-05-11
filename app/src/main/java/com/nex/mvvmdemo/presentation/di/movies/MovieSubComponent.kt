package com.nex.mvvmdemo.presentation.di.movies


import com.nex.mvvmdemo.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
   fun inject(movieActivity: MovieActivity)

   @Subcomponent.Factory
   interface Factory{
       fun create():MovieSubComponent
   }
}