package com.nex.mvvmdemo.data.repository.movie

import android.util.Log
import com.nex.mvvmdemo.data.model.movies.Movie
import com.nex.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.nex.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.nex.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.nex.mvvmdemo.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
    ) :MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
       return getMovieFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
      val newListofMovies=getMoviesFromAPI()
        movieLocalDataSource.clearAllFromLocalDB()
        movieLocalDataSource.saveMoviesFromLocalDB(newListofMovies)
        movieCacheDataSource.saveMoviesFromCache(newListofMovies)
        return newListofMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
          val response =movieRemoteDataSource.getMovies()
            val body=response.body()
            if(body!=null){
                movieList=body.movies
            }

        }catch (ex:Exception){
            Log.i("MyTag",ex.message.toString())
        }

        return movieList
    }


    suspend fun getMovieFromDB():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
           movieList=movieLocalDataSource.getMoviesFromLocalDB()
        }catch (ex:Exception){
            Log.i("MyTag",ex.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }else{
            movieList =getMoviesFromAPI()
            movieLocalDataSource.saveMoviesFromLocalDB(movieList)
        }
        return movieList
    }


    suspend fun getMovieFromCache():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList=movieCacheDataSource.getMoviesFromCache()
        }catch (ex:Exception){
            Log.i("MyTag",ex.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }else{
            movieList =getMovieFromDB()
           movieCacheDataSource.saveMoviesFromCache(movieList)
        }
        return movieList

    }
}