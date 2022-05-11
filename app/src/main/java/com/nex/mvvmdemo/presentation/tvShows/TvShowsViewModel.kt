package com.nex.mvvmdemo.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nex.mvvmdemo.domain.usecase.GetTvShowsUseCase
import com.nex.mvvmdemo.domain.usecase.UpdateTvShowsUseCase

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows()= liveData {
        val tvShowList= getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows()= liveData {
        val tvShowList= updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}