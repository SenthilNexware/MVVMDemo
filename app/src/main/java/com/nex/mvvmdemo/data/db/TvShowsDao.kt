package com.nex.mvvmdemo.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nex.mvvmdemo.data.model.tvshows.TvShow

@Dao
interface TvShowsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows:List<TvShow>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteTvShows()

    @Query("SELECT * FROM popular_tv_shows")
    suspend fun getTvShows():List<TvShow>
}