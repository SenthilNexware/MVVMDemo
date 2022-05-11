package com.nex.mvvmdemo.domain.usecase

import com.nex.mvvmdemo.data.model.tvshows.TvShow
import com.nex.mvvmdemo.domain.repository.TvShowsRepository

class UpdateTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {
    suspend fun execute():List<TvShow>?=tvShowsRepository.updateTvShows()
}