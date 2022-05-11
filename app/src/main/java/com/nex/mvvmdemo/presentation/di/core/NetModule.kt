package com.nex.mvvmdemo.presentation.di.core

import com.google.gson.GsonBuilder
import com.nex.mvvmdemo.data.api.TMDBServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl:String) {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit):TMDBServices{
        return retrofit.create(TMDBServices::class.java)
    }


}