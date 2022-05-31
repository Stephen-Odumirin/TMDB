package com.stdev.tmdb.ui.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.stdev.tmdb.domain.usecase.GetTvShowUseCase
import com.stdev.tmdb.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel(){

    fun getTvShows() = liveData {
        val tvShows = getTvShowUseCase.excuete()
        emit(tvShows)
    }

    fun updateTvShows() = liveData {
        val tvShows = updateTvShowUseCase.exceute()
        emit(tvShows)
    }

}