package com.nex.mvvmdemo.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nex.mvvmdemo.domain.usecase.GetTvShowsUseCase
import com.nex.mvvmdemo.domain.usecase.UpdateTvShowsUseCase

class TvShowsViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowsViewModel(getTvShowsUseCase,updateTvShowsUseCase) as T
    }
}