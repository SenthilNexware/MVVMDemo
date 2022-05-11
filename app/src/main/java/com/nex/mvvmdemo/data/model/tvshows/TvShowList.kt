package com.nex.mvvmdemo.data.model.tvshows

import com.google.gson.annotations.SerializedName


data class TvShowList(

    @SerializedName("results")
    val tvShows: List<TvShow>,

    )